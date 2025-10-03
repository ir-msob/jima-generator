import fs from 'fs';
import path from 'path';

/**
 * Class representing the file writing operations.
 */
export default class Writing {
    /**
     * Create a Writing instance.
     * @param {Object} generator - The generator object.
     */
    constructor(generator) {
        this.generator = generator;
    }

    /**
     * Copy files based on the application type.
     */
    copyFiles() {
        const templateDir = this.generator.templatePath();
        const destinationDir = this.generator.destinationPath();
        this.generator.log('Available templates:', fs.readdirSync(templateDir));

        if (this.generator.appType === 'Parent') {
            this.generator.log('Copying files for Parent application type.');
            this._copyFilesRecursively(templateDir, destinationDir);
        } else if (this.generator.appType === 'Service') {
            this.generator.log('Copying files for Service application type.');
            this.prepareServiceName();
            this._copyFilesRecursively(templateDir, destinationDir);
        } else if (this.generator.appType === 'Domain') {
            this.generator.log('Copying files for Domain application type.');
            this.prepareServiceName();
            this.prepareDomainName();
            this.prepareClassesPath();
            this._copyFilesRecursively(templateDir, destinationDir);
        }

    }

    /**
     * Recursively copy files from source directory to destination directory.
     * @param {string} srcDir - The source directory.
     * @param {string} destDir - The destination directory.
     */
    _copyFilesRecursively(srcDir, destDir) {
        try {
            const files = fs.readdirSync(srcDir);
            this.generator.log(`Copying files from ${srcDir} to ${destDir}.`);
            files.forEach(file => {
                const srcPath = path.join(srcDir, file);
                const tempFileName = this._replacePlaceholders(file);

                if (this._shouldSkipFolder(file)) {
                    this.generator.log(`[INFO] Skipping folder: ${file}`);
                    return;
                }

                let destPath = path.join(destDir, tempFileName);

                if (fs.existsSync(srcPath)) {
                    const stat = fs.statSync(srcPath);
                    this.generator.log(`Processing: ${srcPath} -> ${destPath}`);

                    if (stat.isDirectory()) {
                        fs.mkdirSync(destPath, {recursive: true});
                        this._copyFilesRecursively(srcPath, destPath);
                    } else {
                        // Always copy/replace the file, even if it exists
                        // Ensure parent directory exists
                        const parentDir = path.dirname(destPath);
                        if (!fs.existsSync(parentDir)) {
                            fs.mkdirSync(parentDir, {recursive: true});
                        }
                        
                        // Read template content and replace placeholders
                        let content = fs.readFileSync(srcPath, 'utf8');
                        const templateVars = this._getTemplateVariables();
                        
                        // Replace template variables in content
                        for (const [key, value] of Object.entries(templateVars)) {
                            const regex = new RegExp(`<%= ${key} %>`, 'g');
                            content = content.replace(regex, value);
                        }
                        
                        // Write the processed content to destination
                        fs.writeFileSync(destPath, content, 'utf8');
                    }
                } else {
                    this.generator.log(`Source path does not exist: ${srcPath}`);
                }
            });
        } catch (error) {
            this.generator.log(`Error while copying files: ${error.message}`);
        }
    }


    /**
     * Replace placeholders in the file name with actual values.
     * @param {string} file - The file name.
     * @returns {string} - The file name with placeholders replaced.
     */
    _replacePlaceholders(file) {
        const replacements = {
            '_projectNameLowercase': this.generator.projectNameLowercase,
            '_projectName': this.generator.projectName,
            '_serviceNameLowercase': this.generator.serviceNameLowercase,
            '_serviceNameWithHyphen': this.generator.serviceNameWithHyphen,
            '_serviceName': this.generator.serviceName,
            '_domainClassNameLowercase': this.generator.domainClassNameLowercase,
            '_domainClassName': this.generator.domainClassName,
            '_dtoClassName': this.generator.dtoClassName,
            '_criteriaClassName': this.generator.criteriaClassName,
            '_packagePath': this.generator.packagePath.split('.').join('/')
        };

        let tempFileName = file;
        
        // Sort replacements by length (longest first) to avoid partial replacements
        const sortedReplacements = Object.entries(replacements).sort((a, b) => b[0].length - a[0].length);
        
        for (const [placeholder, value] of sortedReplacements) {
            // Escape special regex characters and replace only complete placeholders
            const escapedPlaceholder = placeholder.replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
            const regex = new RegExp(escapedPlaceholder, 'gi');
            tempFileName = tempFileName.replace(regex, value);
        }

        // Remove any text inside square brackets (e.g. [Domain], [Test], etc.)
        tempFileName = tempFileName.replace(/\[.*?\]/g, '');

        if (this.generator.isRestful && file.includes('_restful')) {
            this.generator.log(`[INFO] Remove _restful: ${file}`);
            tempFileName = tempFileName.replace(/_restful/gi, '');
        }

        if (this.generator.isKafka && file.includes('_kafka')) {
            this.generator.log(`[INFO] Remove _kafka: ${file}`);
            tempFileName = tempFileName.replace(/_kafka/gi, '');
        }

        return tempFileName;
    }

    /**
     * Determine if a folder should be skipped based on certain conditions.
     * @param {string} file - The file name.
     * @returns {boolean} - Returns true if the folder should be skipped, otherwise false.
     */
    _shouldSkipFolder(file) {
        const conditions = [
            !this.generator.isRestful && file.toLowerCase() === 'restful',
            !this.generator.isKafka && file.toLowerCase() === 'kafka',
            this.generator.security !== 'Keycloak' && file.toLowerCase() === 'keycloak',
            this.generator.appType !== 'Service' && file === '_serviceNameWithHyphen-service',
            this.generator.appType !== 'Parent' && file === '_projectNameLowercase-parent',
            this.generator.appType !== 'Parent' && file === '_projectNameLowercase-core',
            this.generator.appType !== 'Parent' && file === '_projectNameLowercase-domain',
            this.generator.appType !== 'Domain' && file === '_serviceNameWithHyphen-service[Domain]',
            this.generator.appType !== 'Domain' && file === '_projectNameLowercase-domain[Domain]'
        ];

        return conditions.some(condition => condition);
    }

    /**
     * Get the template variables for file generation.
     * @returns {Object} - The template variables.
     */
    _getTemplateVariables() {
        return {
            projectName: this.generator.projectName,
            projectNameLowercase: this.generator.projectNameLowercase,
            projectNameWithHyphen: this.generator.projectNameWithHyphen,
            projectVersion: this.generator.projectVersion,
            jimaVersion: this.generator.jimaVersion,
            packagePath: this.generator.packagePath,
            reversePackagePath: this.generator.reversePackagePath,
            idClassPath: this.generator.idClassPath,
            idClassName: this.generator.idClassName,
            databaseType: this.generator.databaseType,
            databaseTypeLowercase: this.generator.databaseTypeLowercase,
            features: this.generator.features,
            isRestful: this.generator.isRestful,
            isKafka: this.generator.isKafka,
            security: this.generator.security,
            securityLowercase: this.generator.securityLowercase,
            commonConfigPath: this.generator.commonConfigPath,
            serviceName: this.generator.serviceName,
            serviceNameLowercase: this.generator.serviceNameLowercase,
            serviceNameWithHyphen: this.generator.serviceNameWithHyphen,
            domainClassPath: this.generator.domainClassPath,
            domainClassName: this.generator.domainClassName,
            domainClassNameLowercase: this.generator.domainClassNameLowercase,
            domainClassNameWithHyphen: this.generator.domainClassNameWithHyphen,
            dtoClassPath: this.generator.dtoClassPath,
            dtoClassName: this.generator.dtoClassName,
            criteriaClassPath: this.generator.criteriaClassPath,
            criteriaClassName: this.generator.criteriaClassName,
            domainSerialVersionUID: this.generator.domainSerialVersionUID,
            dtoSerialVersionUID: this.generator.dtoSerialVersionUID,
            criteriaSerialVersionUID: this.generator.criteriaSerialVersionUID
        };
    }

    /**
     * Prepare the class paths for the domain.
     */
    prepareClassesPath() {
        this.generator.log('Preparing class paths for domain:', this.generator.domainName);
        this.generator.domainClassPath = `${this.generator.packagePath}.${this.generator.projectNameLowercase}.commondto.commons.${this.generator.domainNameLowercase}.${this.generator.domainName}`;
        this.generator.domainClassName = this.generator.domainClassPath.split('.').pop();
        this.generator.domainClassNameLowercase = this.generator.domainClassName.toLowerCase();
        this.generator.domainClassNameWithHyphen = this.generator.domainClassName
            .replace(/\s+/g, '-')
            .replace(/([a-z])([A-Z])/g, '$1-$2')
            .toLowerCase();

        this.generator.dtoClassPath = `${this.generator.domainClassPath}Dto`;
        this.generator.dtoClassName = this.generator.dtoClassPath.split('.').pop();

        this.generator.criteriaClassPath = `${this.generator.domainClassPath}Criteria`;
        this.generator.criteriaClassName = this.generator.criteriaClassPath.split('.').pop();

        // Generate unique serialVersionUID for each class
        this.generator.domainSerialVersionUID = this.generateSerialVersionUID(this.generator.domainClassName);
        this.generator.dtoSerialVersionUID = this.generateSerialVersionUID(this.generator.dtoClassName);
        this.generator.criteriaSerialVersionUID = this.generateSerialVersionUID(this.generator.criteriaClassName);
    }

    /**
     * Prepare the domain name and related properties.
     */
    prepareDomainName() {
        this.generator.log('Preparing domain name:', this.generator.domainName);
        this.generator.domainNameLowercase = this.generator.domainName.toLowerCase();
        this.generator.domainNameWithHyphen = this.generator.domainName.replace(/\s+/g, '-').toLowerCase();
    }

    /**
     * Generate a unique serialVersionUID based on class name.
     * @param {string} className - The class name to generate UID for.
     * @returns {string} - The generated serialVersionUID.
     */
    generateSerialVersionUID(className) {
        // Create a simple hash from the class name
        let hash = 0;
        for (let i = 0; i < className.length; i++) {
            const char = className.charCodeAt(i);
            hash = ((hash << 5) - hash) + char;
            hash = hash & hash; // Convert to 32-bit integer
        }

        // Convert to positive number and format as negative long
        const positiveHash = Math.abs(hash);
        const baseUID = 8938843863555450000; // Base UID
        const uniqueUID = baseUID + positiveHash;

        return `-${uniqueUID}L`;
    }

    /**
     * Prepare the service name and related properties.
     */
    prepareServiceName() {
        this.generator.log('Preparing service name:', this.generator.serviceName);
        this.generator.serviceNameLowercase = this.generator.serviceName.toLowerCase();
        this.generator.serviceNameWithHyphen = this.generator.serviceName.replace(/\s+/g, '-').toLowerCase();
    }
}