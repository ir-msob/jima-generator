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
        console.log('Available templates:', fs.readdirSync(templateDir));

        this._copyFilesRecursively(templateDir, destinationDir);
    }

    _copyFilesRecursively(srcDir, destDir) {
        fs.readdirSync(srcDir).forEach(file => {
            const srcPath = path.join(srcDir, file);
            let destPath = path.join(destDir, file);

            // Replace "project" in the folder name with projectNameLowercase
            if (file.includes('_projectNameLowercase')) {
                const newFileName = file.replace(/_projectNameLowercase/gi, this.generator.projectNameLowercase);
                destPath = path.join(destDir, newFileName);
            }

            // Check if the folder name is 'pkg' and adjust the path
            if (file === '_packagePath') {
                const packageFolders = this.generator.packagePath.split('.');
                destPath = path.join(destDir, ...packageFolders);
            }

            // Check if the folder name is 'restful' and isRestful is false
            if (!this.generator.isRestful && file.toLowerCase() === 'restful') {
                console.log(`[INFO] Skipping folder: ${file}`);
                return; // Skip this iteration
            }

            // Check if the folder name is 'kafka' and isKafka is false
            if (!this.generator.isKafka && file.toLowerCase() === 'kafka') {
                console.log(`[INFO] Skipping folder: ${file}`);
                return; // Skip this iteration
            }

            // Check if the folder name is 'keycloak' and security is not Keycloak
            if (this.generator.security !== 'Keycloak' && file.toLowerCase() === 'keycloak') {
                console.log(`[INFO] Skipping folder: ${file}`);
                return; // Skip this iteration
            }

            // Check if the folder name is 'springauthorizationserver' and security is not SpringAuthorizationServer
            if (this.generator.security !== 'SpringAuthorizationServer' && file.toLowerCase() === 'springauthorizationserver') {
                console.log(`[INFO] Skipping folder: ${file}`);
                return; // Skip this iteration
            }

            if (fs.existsSync(srcPath)) {
                const stat = fs.statSync(srcPath);
                console.log(`Processing: ${srcPath} -> ${destPath}`);

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
                        securityLowercase: this.generator.securityLowercase
                    });
                }
            } else {
                console.error(`Source path does not exist: ${srcPath}`);
            }
        });
    }
}
