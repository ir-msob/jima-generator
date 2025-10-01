import Generator from 'yeoman-generator';
import Prompts from './prompts/prompts.js';
import Writing from './writing/writing.js';

/**
 * Main Yeoman generator entrypoint for JIMA.
 * Wires prompt collection and file writing lifecycle steps.
 */
export default class AppGenerator extends Generator {
    /**
     * Yeoman lifecycle: set up helper classes before prompts run.
     */
    async initializing() {
        this.prompts = new Prompts(this);
        this.writing = new Writing(this);
    }

    /**
     * Yeoman lifecycle: ask the interactive questions and populate generator state.
     */
    async prompting() {
        await this.prompts.askQuestions();
    }

    /**
     * Yeoman lifecycle: generate files based on collected answers.
     */
    writing() {
        this.writing.copyFiles();
    }
}