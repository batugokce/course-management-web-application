import React, {useState} from 'react'
import Col from "react-bootstrap/Col";
import Card from "react-bootstrap/Card";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Row from "react-bootstrap/Row";
import axios from 'axios'
import Alert from "react-bootstrap/Alert";

function LoginForm() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [alertText, setAlertText] = useState("");
    const [show, setShow] = useState(false);

    let userLogin = (event,username, password) => {
        event.preventDefault();
        console.log(username, password);

        axios.post("/api/authenticate",{
            username: username,
            password: password
        })
            .then(response => {
                console.log(response)
            })
            .catch(error => {
                let statusCode = error.response.status
                switch (statusCode) {
                    case 403:
                        setAlertText("Kullanıcı adı ya da şifre yanlış.");
                        break;
                    default:
                        setAlertText("Bir hatayla karşılaşıldı.")
                        break;
                }
                setShow(true);
                }
            )
    }

    return (
        <Col className = "mx-7"  >
            <Card className = "py-3 px-4 mx-auto " >
                <Form.Label style = {{"fontSize" : "x-large"}} className = "mx-auto" >Kullanıcı Girişi</Form.Label>
                <Form>
                    <Form.Group controlId="formGroupUsernama 2">
                        <Form.Label>Kullanıcı Adı</Form.Label>
                        <Form.Control type="text" placeholder="Kullanıcı adınızı giriniz"
                                      value = {username} onChange={event => setUsername(event.target.value)} />
                    </Form.Group>

                    <Form.Group controlId="formGroupPassword 2">
                        <Form.Label>Şifre</Form.Label>
                        <Form.Control type="password" placeholder="Şifrenizi giriniz"
                                      value = {password} onChange={event => setPassword(event.target.value)} />
                    </Form.Group>

                    <Alert show={show} variant={"danger"} onClose={() => setShow(false)} dismissible>
                        {alertText}
                    </Alert>

                    <Row>
                        <Button className="ml-3" variant="primary" type="submit" onClick = {event => userLogin(event,username,password)}  >
                            Giriş yap
                        </Button>

                    </Row>

                </Form>



            </Card>

        </Col>
    )
}

export default LoginForm;