/**
 * Questions for selecting and defining domain names in Parent projects.
 */
export const domainsQuestions = [
    {
        type: 'checkbox',
        name: 'domains',
        message: 'Please select the domains for which you want to create classes in the common DTO library:',
        choices: [
            { name: 'Party', value: 'Party', checked: true },
        ]
    },
    {
        type: 'input',
        name: 'newDomains',
        message: 'Please enter a list of domain names separated by commas(Order, Payment, Post):',
        default: 'Comment, Order',
    }
];

/**
 * Ask questions related to the domains.
 */
export async function domainsInput(generator) {
    const domainsAnswers = await generator.prompt(domainsQuestions);

    // Built-in domains available out of the box
    generator.existsDomains = ['Party'];

    // Normalize user-provided new domains (trim, remove empties, de-duplicate)
    const parsedNewDomains = (domainsAnswers.newDomains || '')
        .split(',')
        .map(name => name.trim())
        .filter(name => name.length > 0);

    // Merge selected and new domains (unique, preserve order preference: selected first)
    const mergedDomains = Array.from(new Set([...(domainsAnswers.domains || []), ...parsedNewDomains]));

    generator.domains = mergedDomains;
    generator.newDomains = parsedNewDomains.join(', ');
}