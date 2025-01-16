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
    generator.domains = domainsAnswers.domains;
    generator.newDomains = domainsAnswers.newDomains;
}