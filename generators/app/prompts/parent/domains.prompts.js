/**
 * Questions for selecting and defining domain names in Parent projects.
 */
export const domainsQuestions = [
    {
        type: 'input',
        name: 'newDomains',
        message: 'Please enter a list of domain names separated by commas(Order, Payment, Post):',
        default: '',
    }
];

/**
 * Ask questions related to the domains.
 */
export async function domainsInput(generator) {
    const domainsAnswers = await generator.prompt(domainsQuestions);

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