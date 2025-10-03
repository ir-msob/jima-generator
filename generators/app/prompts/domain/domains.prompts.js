/**
 * Questions for selecting and defining domain names in Parent projects.
 */
export const domainsQuestions = [
    {
        type: 'input',
        name: 'serviceName',
        message: 'Please enter the service name (e.g., Comment, Order):',
        default: 'Storage',
        validate: input => /^[A-Z][a-zA-Z]*$/.test(input) || 'Service name must start with an uppercase letter and contain only letters.'
    },
    {
        type: 'input',
        name: 'domainName',
        message: 'Please enter the domain name (e.g., Comment, Order):',
        default: 'Document',
        validate: input => /^[A-Z][a-zA-Z]*$/.test(input) || 'Service name must start with an uppercase letter and contain only letters.'
    }
];

/**
 * Ask questions related to the domains.
 */
export async function domainsInput(generator) {
    const domainsAnswers = await generator.prompt(domainsQuestions);
    generator.serviceName = domainsAnswers.serviceName;
    generator.domainName = domainsAnswers.domainName;
}