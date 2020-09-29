import React from 'react'
import { connect } from 'react-redux'
import * as actions from '../reducers/actions'
import FetchCourses from "../functions/FetchCourses";

function CourseDetailPage(props) {
    const { match, courses } = props
    let courseId = match.params.id;

    return (
        <div>
            <FetchCourses/>
            a {courseId}
            <button onClick={() => {console.log(courses)}} >  buton</button>
        </div>
    )
}

function mapStateToProps(state){
    return {
        courses: state.courses.allCourses
    }
}

export default connect(mapStateToProps, actions)(CourseDetailPage);