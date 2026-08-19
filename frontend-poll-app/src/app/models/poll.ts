import { VoteOption } from "./vote-option";

export interface Poll {

    id?: number;
    question: string;
    options: VoteOption[];
}
