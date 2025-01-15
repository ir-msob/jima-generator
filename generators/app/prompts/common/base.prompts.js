export const baseQuestions = [
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
            {name: 'Restful', value: 'restful', checked: true},
            {name: 'Kafka', value: 'kafka', checked: true},
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
];

/**
 * Ask base questions.
 */
export async function baseInput(generator) {
    const baseAnswers = await generator.prompt(baseQuestions);
    prepareProjectNameVariables(generator, baseAnswers);
    generator.packagePath = baseAnswers.packagePath;
    generator.projectVersion = baseAnswers.projectVersion;
    prepareDatabaseTypeVariables(generator, baseAnswers);
    prepareIdClassVariables(generator, baseAnswers);
    prepareSecurityVariables(generator, baseAnswers);
    prepareFeaturesVariables(generator, baseAnswers);
    generator.jimaVersion = baseAnswers.jimaVersion;
}


/**
 * Prepare database type variables.
 */
function prepareDatabaseTypeVariables(generator, baseAnswers) {
    generator.databaseType = baseAnswers.databaseType;
    generator.databaseTypeLowercase = generator.databaseType.toLowerCase();
}

/**
 * Prepare security variables.
 */
function prepareSecurityVariables(generator, baseAnswers) {
    generator.security = baseAnswers.security;
    generator.securityLowercase = generator.security.toLowerCase();
}

/**
 * Prepare ID class variables.
 */
function prepareIdClassVariables(generator, baseAnswers) {
    generator.idClassPath = baseAnswers.idClassPath;
    generator.idClassName = generator.idClassPath.split('.').pop();
    const javaWrapperTypes = ['Integer', 'String', 'Short', 'Long', 'Float', 'Double'];
    generator.isWrapperType = javaWrapperTypes.includes(generator.idClassName);
}

/**
 * Prepare project name variables.
 */
function prepareProjectNameVariables(generator, baseAnswers) {
    generator.projectName = baseAnswers.projectName;
    generator.projectNameLowercase = generator.projectName.toLowerCase();
    generator.projectNameWithHyphen = generator.projectName.replace(/\s+/g, '-').toLowerCase();
}

/**
 * Prepare features variables.
 */
function prepareFeaturesVariables(generator, baseAnswers) {
    generator.features = baseAnswers.features;
    generator.isRestful = generator.features.includes('restful');
    generator.isKafka = generator.features.includes('kafka');
}

