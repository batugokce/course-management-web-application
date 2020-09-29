import React, {useEffect} from 'react'
import axios from 'axios';
import { connect } from 'react-redux'
import * as actions from '../reducers/actions'

function FetchCourses(props) {
    const { courses, storeCourses } = props
    const header = {
        headers: {
            Authorization: 'Bearer ' + localStorage.getItem("jwt")
        }
    }

    useEffect(() => {
        if (courses == null) {
            console.log("Course list is being fetched.")
            axios.get("/api/v1/course/list/1", header)
                .then(response => {
                    if (response.data.type === "success") {
                        console.log(response.data.body)
                        storeCourses(response.data.body)
                    }
                })
                .catch(error => {
                    console.log(error.response)
                });
        }

    },[]) // eslint-disable-line react-hooks/exhaustive-deps

    return (
        <div/>
    )
}

function mapStateToProps(state){
    return {
        courses: state.courses.allCourses
    }
}

export default connect(mapStateToProps, actions)(FetchCourses);