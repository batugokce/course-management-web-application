import React, {useEffect} from 'react'
import Container from "react-bootstrap/Container";
import {connect} from "react-redux";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Card from "react-bootstrap/Card";

function CourseDetails(props) {
    const { courses } = props
    const course = courses.find(item => item.courseId.toString() === props.courseId);

    useEffect(() => {
        console.log(course)
    },)

    return (
        <Container>
            {
                course == null ? <Row className={"justify-content-center"} ><h2>Aranan ders bulunamadı.</h2></Row> :
                    <div>
                    <Row>
                        <Col>
                            <Card >
                                <Card.Body>
                                    <Card.Title className="text-center mb-3" >Ders Bilgileri</Card.Title>
                                    <div className={"mt-3"} >
                                        <b>Dersin adı:</b> {course.courseName}
                                    </div>
                                    <div className={"mt-3"} >
                                        <b>Dersin kodu:</b> {course.courseCode}
                                    </div>
                                    <div className={"mt-3"} >
                                        <b>Dersin türü:</b> {course.type}
                                    </div>
                                    <div className={"mt-3"} >
                                        <b>Dönem kodu:</b> {course.semesterNo}
                                    </div>
                                </Card.Body>
                            </Card>
                        </Col>
                        <Col>
                            <Card >
                                <Card.Body>
                                    <Card.Title className="text-center mb-3" >Personel Bilgileri</Card.Title>
                                    <Card.Subtitle>Öğretmenler</Card.Subtitle>
                                    <ul>
                                        {
                                            course.instructors.map(item => <li key={item.nameSurname} >{item.nameSurname}</li>)
                                        }
                                    </ul>
                                    <Card.Subtitle>Asistanlar</Card.Subtitle>
                                    <ul>
                                        {
                                            course.assistants.map(item => <li key={item.nameSurname} >{item.nameSurname}</li>)
                                        }
                                    </ul>
                                </Card.Body>
                            </Card>
                        </Col>
                    </Row>
                    <Row className={"my-3"} >
                        <Col  >
                            <Card >
                                <Card.Body>
                                    <Card.Title className="text-center mb-3" >Duyurular</Card.Title>
                                    {
                                        course.announcements.map(item => <div key={item.id} className={"mt-4"} >
                                            <Card.Subtitle>{item.title}</Card.Subtitle>
                                            <Card.Text>
                                                {item.text}
                                            </Card.Text>
                                        </div>)
                                    }

                                </Card.Body>
                            </Card>
                        </Col>
                    </Row>
                    <Row className={"my-3"}>
                        <Col>
                            <Card >
                                <Card.Body>
                                    <Card.Title className="text-center mb-3" >Ders notları</Card.Title>

                                </Card.Body>
                            </Card>
                        </Col>
                        <Col>
                            <Card >
                                <Card.Body>
                                    <Card.Title className="text-center mb-3" >Sınavlar</Card.Title>
                                    <ul>
                                        {
                                            course.exams.map(item =>
                                                <li key={item.id} >{item.type}: {item.startDate.replace('T',' ')}, konum: {item.location} </li>)
                                        }
                                    </ul>
                                </Card.Body>
                            </Card>
                        </Col>
                    </Row>

                        </div>
            }
        </Container>
    )
}

function mapStateToProps(state){
    return {
        courses: state.courses.allCourses
    }
}

export default connect(mapStateToProps)(CourseDetails);