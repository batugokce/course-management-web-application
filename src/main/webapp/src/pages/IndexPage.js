import React, {useState} from 'react'
import Container from "react-bootstrap/cjs/Container";
import Sidebar from "../components/Sidebar";
import NavBar from "../components/NavBar";
import { slide as Menu } from 'react-burger-menu'

function IndexPage() {
    const [showSidebar, setShowSidebar] = useState(true);

    return (
    <div>
    <NavBar />
    <Sidebar/>


    </div>


    )
}

export default IndexPage;