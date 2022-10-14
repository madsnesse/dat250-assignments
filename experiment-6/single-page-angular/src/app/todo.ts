export class Todo {
    id: number;
    summary: string;
    description: string;
    constructor(id: number, summary: string, description: string) { 
        this.id = id;
        this.description = description; 
        this.summary = summary 
    }
}