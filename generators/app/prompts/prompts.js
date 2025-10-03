import { baseInput } from './common/base.prompts.js';
import { appTypeInput } from './common/app-type.prompts.js';
import { domainsInput } from './domain/domains.prompts.js';
import { serviceInput } from './service/service.prompts.js';

/**
 * Coordinates all prompt flows for the JIMA generator.
 */
export default class Prompts {
    /**
     * Create a Prompts coordinator.
     * @param {Object} generator - Yeoman generator context.
     */
    constructor(generator) {
        this.generator = generator;
        this.generator.domains = this.generator.domains || []; // Initialize domains if not already defined
    }

    /**
     * Orchestrate prompts based on selected application type.
     */
    async askQuestions() {
        this.generator.log('Welcome to the JIMA service generator!');

        // Ask base questions
        await baseInput(this.generator);

        // Ask app type questions
        await appTypeInput(this.generator);

        // Conditional questions based on app type
        if (this.generator.appType === 'Domain') {
            // Ask domain-related questions if app type is 'Parent'
            await domainsInput(this.generator);

        } else if (this.generator.appType === 'Service') {
            // Ask service-related questions if app type is 'Service'
            await serviceInput(this.generator);
        }
    }
}