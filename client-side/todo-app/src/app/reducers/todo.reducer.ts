import { ActionParent } from "../actions/todo.action";
import { Todo } from "../models/Todo";

const initialState: Todo [] = [
    {title: "title 1"},
    {title: "title 2"},
    {title: "title 3"}
];

export function Todoreducer(state = initialState, action: ActionParent) {
    switch(action) {
        default: return state;
    }
}