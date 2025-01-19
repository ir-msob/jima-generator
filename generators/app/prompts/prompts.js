import { baseInput } from './common/base.prompts.js';
import { appTypeInput } from './common/app-type.prompts.js';
import { domainsInput } from './parent/domains.prompts.js';
import { serviceInput } from './service/service.prompts.js';
import { newServiceInput } from './service/new-service.prompts.js';

/**
 * Class representing a set of prompts for the JIMA service generator.
 */
export default class Prompts {
    /**
     * Create a Prompts instance.
     * @param {Object} generator - The generator object.
     */
    constructor(generator) {
        this.generator = generator;
        this.generator.domains = this.generator.domains || []; // Initialize domains if not already defined
    }

    /**
     * Ask a series of questions based on the generator's app type.
     * @async
     */
    async askQuestions() {
        this.generator.log('Welcome to the JIMA service generator!');

        // Ask base questions
        await baseInput(this.generator);

        // Ask app type questions
        await appTypeInput(this.generator);

        // Conditional questions based on app type
        if (this.generator.appType === 'Parent') {
            // Ask domain-related questions if app type is 'Parent'
            await domainsInput(this.generator);

        } else if (this.generator.appType === 'Service') {
            // Ask service-related questions if app type is 'Service'
            await serviceInput(this.generator);

            // Ask new service-related questions if service name is 'New'
            if (this.generator.serviceName === 'New') {
                await newServiceInput(this.generator);
            }else {
                this.generator.domains.push(this.generator.serviceName);
            }
        }
    }
}