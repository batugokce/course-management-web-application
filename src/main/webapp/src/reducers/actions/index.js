import { STORE_COURSES } from './types'


export function storeCourses(courseList) {
    return {
        type: STORE_COURSES,
        payload: courseList
    };
}