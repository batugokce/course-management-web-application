import React from 'react'
import { connect } from 'react-redux'
import * as actions from '../reducers/actions'
import FetchCourses from "../functions/FetchCourses";
import NavBar from "../components/NavBar";
import Sidebar from "../components/Sidebar";
import CourseDetails from "../components/CourseDetails";

function CourseDetailPage(props) {
    const { match } = props
    let courseId = match.params.id;

    return (
        <div>
            <NavBar />
            <Sidebar />
            <FetchCourses/>
            <CourseDetails courseId={courseId} />
        </div>
    )
}

function mapStateToProps(state){
    return {
        courses: state.courses.allCourses
    }
}

export default connect(mapStateToProps, actions)(CourseDetailPage);