import React from 'react'
import NavBar from "../components/NavBar";
import Sidebar from "../components/Sidebar";
import CourseTableForStudent from "../components/CourseTableForStudent";
import FetchCourses from "../functions/FetchCourses";

function CoursePage() {
    return (
        <div>
            <NavBar />
            <Sidebar />
            <FetchCourses/>
            <CourseTableForStudent />
        </div>
    )
}

export default CoursePage;