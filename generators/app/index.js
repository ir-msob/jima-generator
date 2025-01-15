import Generator from 'yeoman-generator';
import Prompts from './prompts/prompts.js';
import Writing from './writing/writing.js';

export default class extends Generator {
    async initializing() {
        this.prompts = new Prompts(this);
        this.writing = new Writing(this);
    }

    async prompting() {
        await this.prompts.askQuestions();
    }

    writing() {
        this.writing.copyFiles();
    }
}