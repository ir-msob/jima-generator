export const entitiesQuestions = [
    {
        type: 'checkbox',
        name: 'entities',
        message: 'Please select the entities for which you want to create classes in the common DTO library:',
        choices: [
            { name: 'Party', value: 'Party', checked: false },
        ]
    },
    {
        type: 'input',
        name: 'newEntities',
        message: 'Please enter a list of domain names separated by commas(Order,Payment,Post):'
    },
];

/**
 * Ask questions related to the entities.
 */
export async function entitiesInput(generator) {
    const entitiesAnswers = await generator.prompt(entitiesQuestions);
    generator.entities = entitiesAnswers.entities;
    generator.newEntities = entitiesAnswers.newEntities;
}