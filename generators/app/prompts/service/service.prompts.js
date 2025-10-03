/**
 * Questions specific to Service projects.
 */
export const serviceQuestions = [
    {
        type: 'input',
        name: 'serviceVersion',
        message: 'Please enter the service version (e.g., 0.1.0):',
        default: '0.1.0',
        validate: input => /^\d+\.\d+\.\d+$/.test(input) || 'Version must be in the format x.y.z (e.g., 0.1.0).'
    },
    {
        type: 'input',
        name: 'serviceName',
        message: 'Please enter the service name (e.g., Comment, Order):',
        default: 'Order',
        validate: input => /^[A-Z][a-zA-Z]*$/.test(input) || 'Service name must start with an uppercase letter and contain only letters.'
    }
];

/**
 * Prompt for service-specific answers and set them on the generator.
 */
export async function serviceInput(generator) {
    const serviceAnswers = await generator.prompt(serviceQuestions);
    generator.serviceName = serviceAnswers.serviceName;
    generator.serviceVersion = serviceAnswers.serviceVersion;
}