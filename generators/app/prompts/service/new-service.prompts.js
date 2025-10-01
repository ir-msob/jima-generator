/**
 * Question for defining a new service name when "New" is selected.
 */
export const newServiceQuestions = [
    {
        type: 'input',
        name: 'serviceName',
        message: 'Please enter the service name (e.g., Comment, Order):',
        default: 'Order',
        validate: input => /^[A-Z][a-zA-Z]*$/.test(input) || 'Service name must start with an uppercase letter and contain only letters.'
    }
];

/**
 * Prompt for new service name and set it on the generator.
 */
export async function newServiceInput(generator) {
    const newServiceAnswers = await generator.prompt(newServiceQuestions);
    generator.serviceName = newServiceAnswers.serviceName;
}