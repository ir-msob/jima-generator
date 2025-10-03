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
        name: 'newDomains',
        message: 'Please enter a list of domain names separated by commas(Order, Payment, Post):',
        default: 'Document',
    }
];

/**
 * Ask questions related to the domains.
 */
export async function domainsInput(generator) {
    const domainsAnswers = await generator.prompt(domainsQuestions);
    generator.serviceName = domainsAnswers.serviceName;

    // Built-in domains available out of the box
    generator.existsDomains = [];

    // Normalize user-provided new domains (trim, remove empties, de-duplicate)
    const parsedNewDomains = (domainsAnswers.newDomains || '')
        .split(',')
        .map(name => name.trim())
        .filter(name => name.length > 0);

    // Set domains based only on user-provided new domains
    generator.domains = parsedNewDomains;
    generator.newDomains = parsedNewDomains.join(', ');
}