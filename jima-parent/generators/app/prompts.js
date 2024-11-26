export default class Prompts {
    constructor(generator) {
        this.generator = generator;
    }

    async askQuestions() {
        this.generator.log('Welcome to the service generator!');

        const answers = await this.generator.prompt([
            {
                type: 'input',
                name: 'projectName',
                message: 'Please enter the project name:',
                default: 'MyProject',
                validate: input => /^[A-Z][a-zA-Z0-9]*$/.test(input) || 'Project name must start with an uppercase letter and contain only alphanumeric characters.'
            },
            {
                type: 'input',
                name: 'packagePath',
                message: 'Please enter the base package path (e.g., com.example.project):',
                default: 'com.example',
                validate: input => /^[a-z]+\.[a-z]+(\.[a-z]+)*$/.test(input) || 'Package name must be in the format: com.example (lowercase letters only).'
            },
            {
                type: 'input',
                name: 'projectVersion',
                message: 'Please enter the project version:',
                default: '0.1.0'
            },
            {
                type: 'list',
                name: 'databaseType',
                message: 'Please enter the database type:',
                choices: [
                    {name: 'Mongo', value: 'Mongo'}
                ],
                default: 'Mongo'
            },
            {
                type: 'input',
                name: 'idClassPath',
                message: 'Please enter the ID class:',
                default: 'java.lang.String',
                validate: input => /^(?:[a-zA-Z_][a-zA-Z0-9_]*\.)+[A-Z][a-zA-Z0-9_]*$/.test(input) || 'ID class must be a valid Java class name with a package (e.g., java.lang.String).'
            },
            {
                type: 'list',
                name: 'security',
                message: 'Please select the security type:',
                choices: [
                    {name: 'Keycloak', value: 'Keycloak'},
                    {name: 'Spring Authorization Server', value: 'SpringAuthorizationServer'}
                ],
                default: 'Keycloak'
            },
            {
                type: 'checkbox',
                name: 'features',
                message: 'Select features to include:',
                choices: [
                    { name: 'RESTful', value: 'restful', checked: true },
                    { name: 'Kafka', value: 'kafka', checked: true },
                ],
            },
            {
                type: 'list',
                name: 'jimaVersion',
                message: 'Please enter the Jima version:',
                choices: [
                    {name: '1.3.0', value: '1.3.0'},
                    {name: '1.3.1', value: '1.3.1'}
                ],
                default: '1.3.1'
            }
        ]);

        // Project Name
        this.generator.projectName = answers.projectName;
        this.generator.projectNameLowercase = this.generator.projectName.toLowerCase();
        this.generator.projectNameWithHyphen = this.generator.projectName.replace(/\s+/g, '-').toLowerCase();

        // Package Name
        this.generator.packagePath = answers.packagePath;

        // Project Version
        this.generator.projectVersion = answers.projectVersion;

        // Jima Version
        this.generator.jimaVersion = answers.jimaVersion;

        // ID Class
        this.generator.idClassPath = answers.idClassPath;
        this.generator.idClassName = this.generator.idClassPath.split('.').pop();
        // Check if idClassPath is a Java wrapper type
        const javaWrapperTypes = ['Integer', 'String', 'Short', 'Long', 'Float', 'Double'];
        this.generator.isWrapperType = javaWrapperTypes.includes(this.generator.idClassName);

        // Database Type
        this.generator.databaseType = answers.databaseType;
        this.generator.databaseTypeLowercase = this.generator.databaseType.toLowerCase();

        // Security
        this.generator.security = answers.security;
        this.generator.securityLowercase = this.generator.security.toLowerCase();

        // Features
        this.generator.features = answers.features;
        this.generator.isRestful = this.generator.features.includes('restful');
        this.generator.isKafka = this.generator.features.includes('kafka');
    }
}
