/**
 * Questions for selecting application type (Parent or Service).
 */
export const appTypeQuestions = [
    {
        type: 'list',
        name: 'appType',
        message: 'Please select the app type:',
        choices: [
            { name: 'Parent', value: 'Parent' },
            { name: 'Service', value: 'Service' }
        ],
        default: 'Parent',
        validate: input => input ? true : 'You must select an app type.'
    }
];

/**
 * Prompt and set the application type on the generator.
 */
export async function appTypeInput(generator) {
    const appTypeAnswers = await generator.prompt(appTypeQuestions);
    generator.appType = appTypeAnswers.appType;
}