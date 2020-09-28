import React from 'react'
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import Form from 'react-bootstrap/Form';

function NavBar(props) {
    return (
        <Navbar bg="dark" variant="dark">
            <Navbar.Brand>Kurs Yönetim Sistemi</Navbar.Brand>
            <Nav className="mr-auto">
                <Nav.Link href="/index">Anasayfa</Nav.Link>
            </Nav>
            <Form inline style = {{"color" : "rgba(255,255,255,.8)"}}>
                <Nav.Link href="/home" style = {{"color" : "rgba(255,255,255,.8)"}} >Oturumu kapat</Nav.Link>
            </Form>
        </Navbar>
    )
}

export default NavBar;