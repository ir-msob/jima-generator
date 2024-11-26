import fs from 'fs';
import path from 'path'; // Ensure this line is present

export default class Prompts {
    constructor(generator) {
        this.generator = generator;
    }

    async askQuestions() {
        this.generator.log('Welcome to the Service Generator!');

        const answers = await this.generator.prompt([
            {
                type: 'input',
                name: 'commonConfigPath',
                message: 'Please enter the path for the common configuration file (e.g., /path/to/common-config.json):',
                default: '/Workspace/JiWorkspace/jima-generator/test/myproject-common/common-config.json',
                validate: input => {
                    const trimmedInput = input.trim();
                    const pathRegex = /^(\/[^/ ]*)+\/?[^/ ]+$/; // Basic regex for Unix-like paths

                    if (trimmedInput === '') {
                        return 'Path cannot be empty.';
                    }
                    if (!pathRegex.test(trimmedInput)) {
                        return 'Please enter a valid file path (e.g., /path/to/file.json).';
                    }
                    return true; // Valid input
                }
            },
            {
                type: 'input',
                name: 'serviceName',
                message: 'Please enter the service name (e.g., Comment, Order):',
                default: 'Order',
                validate: input => /^[A-Z][a-zA-Z]*$/.test(input) || 'Service name must start with an uppercase letter and contain only letters.'
            },
            {
                type: 'input',
                name: 'domainClassPath',
                message: 'Please enter the fully qualified domain class path (e.g., com.example.project.common.Order):',
                default: 'com.example.project.common.Order',
                validate: input => /^(?:[a-zA-Z_][a-zA-Z0-9_]*\.)+[A-Z][a-zA-Z0-9_]*$/.test(input) || 'Domain class must be a valid Java class path.'
            },
            {
                type: 'input',
                name: 'dtoClassPath',
                message: 'Please enter the fully qualified DTO class path (e.g., com.example.project.common.OrderDTO):',
                default: 'com.example.project.common.OrderDTO',
                validate: input => /^(?:[a-zA-Z_][a-zA-Z0-9_]*\.)+[A-Z][a-zA-Z0-9_]*$/.test(input) || 'DTO class must be a valid Java class path.'
            },
            {
                type: 'input',
                name: 'criteriaClassPath',
                message: 'Please enter the fully qualified criteria class path (e.g., com.example.project.common.OrderCriteria):',
                default: 'com.example.project.common.OrderCriteria',
                validate: input => /^(?:[a-zA-Z_][a-zA-Z0-9_]*\.)+[A-Z][a-zA-Z0-9_]*$/.test(input) || 'Criteria class must be a valid Java class path.'
            },
            {
                type: 'input',
                name: 'serviceVersion',
                message: 'Please enter the service version (e.g., 0.1.0):',
                default: '0.1.0',
                validate: input => /^\d+\.\d+\.\d+$/.test(input) || 'Version must be in the format x.y.z (e.g., 0.1.0).'
            }
        ]);

        // Common Config Path
        this.generator.commonConfigPath = answers.commonConfigPath;
        // Read and parse the configuration file
        this.loadConfig();

        // Project Name
        this.generator.serviceName = answers.serviceName;
        this.generator.serviceNameLowercase = this.generator.serviceName.toLowerCase();
        this.generator.serviceNameWithHyphen = this.generator.serviceName.replace(/\s+/g, '-').toLowerCase();

        // Domain Class
        this.generator.domainClassPath = answers.domainClassPath;
        this.generator.domainClassName = this.generator.domainClassPath.split('.').pop();
        this.generator.domainClassNameLowercase = this.generator.domainClassName.toLowerCase();
        this.generator.domainClassNameWithHyphen = this.generator.domainClassName.replace(/\s+/g, '-').toLowerCase();

        // DTO Class
        this.generator.dtoClassPath = answers.dtoClassPath;
        this.generator.dtoClassName = this.generator.dtoClassPath.split('.').pop();

        // Criteria Class
        this.generator.criteriaClassPath = answers.criteriaClassPath;
        this.generator.criteriaClassName = this.generator.criteriaClassPath.split('.').pop();

    }
    loadConfig() {
        try {
            this.generator.log(`loadConfig ${this.generator.commonConfigPath}`);

            const configPath = path.resolve(this.generator.commonConfigPath);
            this.generator.log('loadConfig2');

            const configFile = fs.readFileSync(configPath, 'utf-8');
            const config = JSON.parse(configFile);

            // Set variables based on the config

            // Project Name
            this.generator.projectName = config.projectName;
            this.generator.projectNameLowercase = this.generator.projectName.toLowerCase();
            this.generator.projectNameWithHyphen = this.generator.projectName.replace(/\s+/g, '-').toLowerCase();

            // Package Name
            this.generator.packagePath = config.packagePath;

            // Project Version
            this.generator.projectVersion = config.projectVersion;

            // Jima Version
            this.generator.jimaVersion = config.jimaVersion;

            // ID Class
            this.generator.idClassPath = config.idClassPath;
            this.generator.idClassName = this.generator.idClassPath.split('.').pop();
            // Check if idClassPath is a Java wrapper type
            const javaWrapperTypes = ['Integer', 'String', 'Short', 'Long', 'Float', 'Double'];
            this.generator.isWrapperType = javaWrapperTypes.includes(this.generator.idClassName);

            // Database Type
            this.generator.databaseType = config.databaseType;
            this.generator.databaseTypeLowercase = this.generator.databaseType.toLowerCase();

            // Security
            this.generator.security = config.security;
            this.generator.securityLowercase = this.generator.security.toLowerCase();

            // Features
            this.generator.features = config.features.split(',').map(feature => feature.trim());
            this.generator.isRestful = this.generator.features.includes('restful');
            this.generator.isKafka = this.generator.features.includes('kafka');

            this.generator.log('Configuration loaded successfully.');
        } catch (error) {
            this.generator.log(`Error reading the configuration file: ${error.message}`);
        }
    }
}
