import React from 'react'
import Container from "react-bootstrap/cjs/Container";
import LoginForm from "../components/LoginForm";

function Home() {


    return (
        <Container className = "my-5 py-3" >
            <LoginForm />
        </Container>
    );
}

export default Home;