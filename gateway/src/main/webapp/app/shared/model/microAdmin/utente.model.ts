export interface IUtente {
    id?: number;
    nome?: string;
    congome?: string;
    userName?: string;
}

export class Utente implements IUtente {
    constructor(public id?: number, public nome?: string, public congome?: string, public userName?: string) {}
}
