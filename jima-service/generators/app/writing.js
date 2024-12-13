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

        this._copyFilesRecursively(templateDir, destinationDir);
    }

    _copyFilesRecursively(srcDir, destDir) {
        try {
            const files = fs.readdirSync(srcDir);
            files.forEach(file => {
                const srcPath = path.join(srcDir, file);
                let tempFileName = file; // Start with the original file name

                // Replace placeholders in the file name
                if (file.includes('_projectNameLowercase')) {
                    tempFileName = tempFileName.replace(/_projectNameLowercase/gi, this.generator.projectNameLowercase);
                }
                if (file.includes('_projectName')) {
                    tempFileName = tempFileName.replace(/_projectName/gi, this.generator.projectName);
                }
                if (file.includes('_serviceNameLowercase')) {
                    tempFileName = tempFileName.replace(/_serviceNameLowercase/gi, this.generator.serviceNameLowercase);
                }
                if (file.includes('_serviceNameWithHyphen')) {
                    tempFileName = tempFileName.replace(/_serviceNameWithHyphen/gi, this.generator.serviceNameWithHyphen);
                }
                if (file.includes('_serviceName')) {
                    tempFileName = tempFileName.replace(/_serviceName/gi, this.generator.serviceName);
                }
                if (file.includes('_domainClassNameLowercase')) {
                    tempFileName = tempFileName.replace(/_domainClassNameLowercase/gi, this.generator.domainClassNameLowercase);
                }
                if (file.includes('_domainClassName')) {
                    tempFileName = tempFileName.replace(/_domainClassName/gi, this.generator.domainClassName);
                }
                if (file === '_packagePath') {
                    const packageFolders = this.generator.packagePath.split('.');
                    tempFileName = path.join(...packageFolders);
                }

                // Check if the folder name is 'restful' and isRestful is false
                if (!this.generator.isRestful && file.toLowerCase() === 'restful') {
                    console.log(`[INFO] Skipping folder: ${file}`);
                    return; // Skip this iteration
                }

                // Remove ".restful." in the file name
                if (this.generator.isRestful && file.includes( '_restful')) {
                    console.log(`[INFO] Remove _restful: ${file}`);
                    tempFileName = tempFileName.replace(/_restful/gi, '');
                }

                // Check if the folder name is 'kafka' and isKafka is false
                if (!this.generator.isKafka && file.toLowerCase() === 'kafka') {
                    console.log(`[INFO] Skipping folder: ${file}`);
                    return; // Skip this iteration
                }

                // Remove ".kafka." in the file name
                if (this.generator.isKafka && file.includes( '_kafka')) {
                    console.log(`[INFO] Remove _kafka: ${file}`);
                    tempFileName = tempFileName.replace(/_kafka/gi, '');
                }

                // Check if the folder name is 'keycloak' and security is not Keycloak
                if (this.generator.security !== 'Keycloak' && file.toLowerCase() === 'keycloak') {
                    console.log(`[INFO] Skipping folder: ${file}`);
                    return; // Skip this iteration
                }

                console.log(`[INFO] Final destination path: ${tempFileName}`);

                // Final destination path
                let destPath = path.join(destDir, tempFileName);

                // Resolve conflicts if necessary
                let conflictCounter = 1;
                while (fs.existsSync(destPath)) {
                    const nameWithoutExt = path.basename(tempFileName, path.extname(tempFileName));
                    const ext = path.extname(tempFileName);
                    destPath = path.join(destDir, `${nameWithoutExt}_${conflictCounter}${ext}`);
                    conflictCounter++;
                }

                if (fs.existsSync(srcPath)) {
                    const stat = fs.statSync(srcPath);
                    this.generator.log(`Processing: ${srcPath} -> ${destPath}`);

                    if (stat.isDirectory()) {
                        fs.mkdirSync(destPath, { recursive: true });
                        this._copyFilesRecursively(srcPath, destPath); // Recursively copy files
                    } else {
                        // Use Yeoman's templating to replace placeholders
                        this.generator.fs.copyTpl(srcPath, destPath, {
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
                        });
                    }
                } else {
                    this.generator.log(`Source path does not exist: ${srcPath}`);
                }
            });
        } catch (error) {
            this.generator.log(`Error while copying files: ${error.message}`);
        }
    }
}
