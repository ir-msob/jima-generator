export const appTypeQuestions = [
    {
        type: 'list',
        name: 'appType',
        message: 'Please select the app type:',
        choices: [
            { name: 'Parent', value: 'Parent' },
            { name: 'Service', value: 'Service' }
        ],
        default: 'Service',
        validate: input => input ? true : 'You must select an app type.'
    }
];

/**
 * Ask questions related to the app type.
 */
export async function appTypeInput(generator) {
    const appTypeAnswers = await generator.prompt(appTypeQuestions);
    generator.appType = appTypeAnswers.appType;
}