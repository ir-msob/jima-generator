import fs from 'fs';
import path from 'path';

export default class Writing {
    constructor(generator) {
        this.generator = generator;
    }

    copyFiles() {
        const templateDir = this.generator.templatePath();
        const destinationDir = this.generator.destinationPath();

        // Log available templates
        this.generator.log('Available templates:', fs.readdirSync(templateDir));

        if (this.generator.appType === 'Parent') {
            this._copyFilesRecursively(templateDir, destinationDir);

            const newDomainsList = this.generator.newDomains.split(',').map(entity => entity.trim());
            this.generator.log('newDomainsList:', newDomainsList);

            // Iterate over each entity and copy the _serviceNameWithHyphen folder
            newDomainsList.forEach(domainName => {
                this.generator.log('domainName:', domainName);

                this.prepareDomainName(domainName);
                this.prepareClassesPath();

                const entityTemplateDir = path.join(templateDir, '_projectNameLowercase-commondto/commons/src/main/java/_packagePath/_projectNameLowercase/commondto/commons/_newDomain');
                const entityDestinationDir = path.join(destinationDir, this._replacePlaceholders('_projectNameLowercase-commondto/commons/src/main/java/_packagePath/_projectNameLowercase/commondto/commons/' + this.generator.domainNameLowercase));


                this._copyFilesRecursively(entityTemplateDir, entityDestinationDir);
            });
        } else if (this.generator.appType === 'Service') {
            this.prepareServiceName();
            this.prepareDomainName(this.generator.serviceName);
            this.prepareClassesPath();

            this._copyFilesRecursively(templateDir, destinationDir);
        }
    }

    _copyFilesRecursively(srcDir, destDir) {
        try {
            const files = fs.readdirSync(srcDir);
            files.forEach(file => {
                const srcPath = path.join(srcDir, file);
                const tempFileName = this._replacePlaceholders(file);

                // Skip folders based on conditions
                if (this._shouldSkipFolder(file)) {
                    console.log(`[INFO] Skipping folder: ${file}`);
                    return;
                }

                // Final destination path
                let destPath = path.join(destDir, tempFileName);

                // Resolve conflicts if necessary
                destPath = this._resolveConflicts(destPath, tempFileName, destDir);

                if (fs.existsSync(srcPath)) {
                    const stat = fs.statSync(srcPath);
                    this.generator.log(`Processing: ${srcPath} -> ${destPath}`);

                    if (stat.isDirectory()) {
                        fs.mkdirSync(destPath, {recursive: true});
                        this._copyFilesRecursively(srcPath, destPath); // Recursively copy files
                    } else {
                        // Use Yeoman's templating to replace placeholders
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

    _replacePlaceholders(file) {
        let tempFileName = file;

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

        for (const [placeholder, value] of Object.entries(replacements)) {
            tempFileName = tempFileName.replace(new RegExp(placeholder, 'gi'), value);
        }

        if (this.generator.isRestful && file.includes('_restful')) {
            console.log(`[INFO] Remove _restful: ${file}`);
            tempFileName = tempFileName.replace(/_restful/gi, '');
        }

        if (this.generator.isKafka && file.includes('_kafka')) {
            console.log(`[INFO] Remove _kafka: ${file}`);
            tempFileName = tempFileName.replace(/_kafka/gi, '');
        }

        return tempFileName;
    }

    _shouldSkipFolder(file) {
        return (!this.generator.isRestful && file.toLowerCase() === 'restful') ||
            (!this.generator.isKafka && file.toLowerCase() === 'kafka') ||
            (this.generator.security !== 'Keycloak' && file.toLowerCase() === 'keycloak') ||
            (this.generator.appType !== 'Service' && file === '_serviceNameWithHyphen') ||
            (this.generator.appType !== 'Parent' && file === '_projectNameLowercase-parent') ||
            (this.generator.appType !== 'Parent' && file === '_projectNameLowercase-commondto') ||
            (this.generator.appType !== 'Parent' && file === '_projectNameLowercase-common');
    }

    _resolveConflicts(destPath, tempFileName, destDir) {
        let conflictCounter = 1;
        while (fs.existsSync(destPath)) {
            const nameWithoutExt = path.basename(tempFileName, path.extname(tempFileName));
            const ext = path.extname(tempFileName);
            destPath = path.join(destDir, `${nameWithoutExt}_${conflictCounter}${ext}`);
            conflictCounter++;
        }
        return destPath;
    }

    _getTemplateVariables() {
        return {
            projectName: this.generator.projectName,
            projectNameLowercase: this.generator.projectNameLowercase,
            projectNameWithHyphen: this.generator.projectNameWithHyphen,
            projectVersion: this.generator.projectVersion,
            jimaVersion: this.generator.jimaVersion,
            packagePath: this.generator.packagePath,
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
     * Prepare class paths.
     */
    prepareClassesPath() {
        this.generator.domainClassPath = `${this.generator.packagePath}.commondto.commons.${this.generator.domainNameLowercase}.${this.generator.domainName}`;
        this.generator.domainClassName = this.generator.domainClassPath.split('.').pop();
        this.generator.domainClassNameLowercase = this.generator.domainClassName.toLowerCase();
        this.generator.domainClassNameWithHyphen = this.generator.domainClassName.replace(/\s+/g, '-').toLowerCase();

        this.generator.dtoClassPath = `${this.generator.domainClassPath}Dto`;
        this.generator.dtoClassName = this.generator.dtoClassPath.split('.').pop();

        this.generator.criteriaClassPath = `${this.generator.domainClassPath}Criteria`;
        this.generator.criteriaClassName = this.generator.criteriaClassPath.split('.').pop();
    }

    /**
     * Prepare domain name variables.
     */
    prepareDomainName(domainName) {
        this.generator.domainName = domainName;
        this.generator.domainNameLowercase = this.generator.domainName.toLowerCase();
        this.generator.domainNameWithHyphen = this.generator.domainName.replace(/\s+/g, '-').toLowerCase();
    }

    /**
     * Prepare service name variables.
     */
    prepareServiceName() {
        this.generator.serviceNameLowercase = this.generator.serviceName.toLowerCase();
        this.generator.serviceNameWithHyphen = this.generator.serviceName.replace(/\s+/g, '-').toLowerCase();
    }
}