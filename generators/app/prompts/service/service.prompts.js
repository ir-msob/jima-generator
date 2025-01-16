export const serviceQuestions = [
    {
        type: 'input',
        name: 'serviceVersion',
        message: 'Please enter the service version (e.g., 0.1.0):',
        default: '0.1.0',
        validate: input => /^\d+\.\d+\.\d+$/.test(input) || 'Version must be in the format x.y.z (e.g., 0.1.0).'
    },
    {
        type: 'list',
        name: 'serviceName',
        message: 'Please select the service:',
        choices: [
            { name: 'New', value: 'New' },
            { name: 'Party', value: 'Party' }
        ],
        default: 'New',
        validate: input => input ? true : 'You must select a service.'
    }
];

/**
 * Ask questions related to the service.
 */
export async function serviceInput(generator) {
    const serviceAnswers = await generator.prompt(serviceQuestions);
    generator.serviceName = serviceAnswers.serviceName;
    generator.serviceVersion = serviceAnswers.serviceVersion;
}