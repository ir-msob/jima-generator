import {baseInput} from './common/base.prompts.js';
import {appTypeInput} from './common/app-type.prompts.js';
import {entitiesInput} from './parent/entities.prompts.js';
import {serviceInput} from './service/service.prompts.js';
import {newServiceInput} from './service/new-service.prompts.js';

/**
 * Prompts class to handle user inputs for the generator.
 */
export default class Prompts {
    constructor(generator) {
        this.generator = generator;
    }

    /**
     * Main method to ask all necessary questions.
     */
    async askQuestions() {
        this.generator.log('Welcome to the JIMA service generator!');

        await baseInput(this.generator);
        await appTypeInput(this.generator);

        if (this.generator.appType === 'Parent') {
            await entitiesInput(this.generator);
        } else if (this.generator.appType === 'Service') {
            await serviceInput(this.generator);

            if (this.generator.service === 'New') {
                await newServiceInput(this.generator);
            }


        }
    }


}