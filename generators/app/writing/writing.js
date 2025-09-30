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
            this.prepareDomainName(this.generator.serviceName);
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

                if (this._processNewDomainFolder(file, srcPath, destDir)) {
                    return;
                }

                let destPath = path.join(destDir, tempFileName);
                destPath = this._resolveConflicts(destPath, tempFileName, destDir);

                if (fs.existsSync(srcPath)) {
                    const stat = fs.statSync(srcPath);
                    this.generator.log(`Processing: ${srcPath} -> ${destPath}`);

                    if (stat.isDirectory()) {
                        fs.mkdirSync(destPath, {recursive: true});
                        this._copyFilesRecursively(srcPath, destPath);
                    } else {
                        this.generator.fs.copyTpl(srcPath, destPath, this._getTemplateVariables());
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
     * Process the '_newDomain' folder and copy files for each domain.
     * @param {string} file - The file name.
     * @param {string} srcPath - The source path.
     * @param {string} destDir - The destination directory.
     * @returns {boolean} - Returns true if the folder is processed, otherwise false.
     */
    _processNewDomainFolder(file, srcPath, destDir) {
        if (file === '_newDomain') {
            if(this.generator.appType === 'Service' && this.generator.exsitsDomains.includes(this.generator.serviceName)){
                return true;
            }
            const newDomainsList = this.generator.newDomains.split(',').map(entity => entity.trim());
            this.generator.log('Processing new domains:', newDomainsList);

            newDomainsList.forEach(domainName => {
                this.generator.log('Processing domain:', domainName);
                this.prepareDomainName(domainName);
                this.prepareClassesPath();

                const domainDestDir = path.join(destDir, this.generator.domainNameLowercase);
                fs.mkdirSync(domainDestDir, {recursive: true});
                this._copyFilesRecursively(srcPath, domainDestDir);
            });
            return true;
        }
        return false;
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
        for (const [placeholder, value] of Object.entries(replacements)) {
            tempFileName = tempFileName.replace(new RegExp(placeholder, 'gi'), value);
        }

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
            this.generator.appType !== 'Service' && file === '_serviceNameWithHyphen',
            this.generator.appType !== 'Parent' && file === '_projectNameLowercase-parent',
            this.generator.appType !== 'Parent' && file === '_projectNameLowercase-commondto',
            this.generator.appType !== 'Parent' && file === '_projectNameLowercase-common',
            this.generator.exsitsDomains && this.generator.exsitsDomains.map(domain => domain.toLowerCase()).includes(file) && !this.generator.domains.map(domain => domain.toLowerCase()).includes(file)
        ];

        return conditions.some(condition => condition);
    }

    /**
     * Resolve file name conflicts by appending a counter to the file name.
     * @param {string} destPath - The destination path.
     * @param {string} tempFileName - The temporary file name.
     * @param {string} destDir - The destination directory.
     * @returns {string} - The resolved destination path.
     */
    _resolveConflicts(destPath, tempFileName, destDir) {
        let conflictCounter = 1;
        while (fs.existsSync(destPath)) {
            const nameWithoutExt = path.basename(tempFileName, path.extname(tempFileName));
            const ext = path.extname(tempFileName);
            destPath = path.join(destDir, `${nameWithoutExt}_${conflictCounter}${ext}`);
            conflictCounter++;
        }
        this.generator.log(`Resolved conflict for ${tempFileName}, new path: ${destPath}`);
        return destPath;
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
            criteriaClassName: this.generator.criteriaClassName
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
        this.generator.domainClassNameWithHyphen = this.generator.domainClassName.replace(/\s+/g, '-').toLowerCase();

        this.generator.dtoClassPath = `${this.generator.domainClassPath}Dto`;
        this.generator.dtoClassName = this.generator.dtoClassPath.split('.').pop();

        this.generator.criteriaClassPath = `${this.generator.domainClassPath}Criteria`;
        this.generator.criteriaClassName = this.generator.criteriaClassPath.split('.').pop();
    }

    /**
     * Prepare the domain name and related properties.
     * @param {string} domainName - The domain name.
     */
    prepareDomainName(domainName) {
        this.generator.log('Preparing domain name:', domainName);
        this.generator.domainName = domainName;
        this.generator.domainNameLowercase = domainName.toLowerCase();
        this.generator.domainNameWithHyphen = domainName.replace(/\s+/g, '-').toLowerCase();
        this.generator.newDomains = domainName;
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