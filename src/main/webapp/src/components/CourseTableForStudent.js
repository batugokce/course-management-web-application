import React from 'react'
import Container from "react-bootstrap/cjs/Container";
import Table from "react-bootstrap/Table";
import Row from "react-bootstrap/Row";
import "../style/CourseTableStyle.css"
import { connect } from 'react-redux'
import * as actions from '../reducers/actions'

function CourseTableForStudent(props) {
    const { courses } = props

    return (
        <Container>
            <Row className = "justify-content-md-center mb-3" ><h1 className={"gray"} >Dersler</h1></Row>
            <Row>
                <Table striped bordered hover variant="dark">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Ders Kodu</th>
                        <th>Ders Adı</th>
                        <th>Tür</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        courses ?
                            courses.map(item =>
                                <tr key={item.courseId}  >
                                    <td>{item.courseId}</td>
                                    <td><a href={"/course/" + item.courseId} className={"link-white"}>{item.courseCode}</a></td>
                                    <td><a href={"/course/" + item.courseId} className={"link-white"}>{item.courseName}</a></td>
                                    <td>{item.type}</td>
                                </tr>
                            )
                            : null
                    }
                    </tbody>
                </Table>
            </Row>
        </Container>
    )
}

function mapStateToProps(state){
    return {
        courses: state.courses.allCourses
    }
}

export default connect(mapStateToProps, actions)(CourseTableForStudent);