import {  STORE_COURSES } from './actions/types'

const initialState = { allCourses: null}

export default function(state = initialState, action) {
    switch (action.type) {
        case STORE_COURSES:
            return {
                allCourses: action.payload
            };
        default:
            return state;
    }
}