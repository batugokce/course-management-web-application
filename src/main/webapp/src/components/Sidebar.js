import React from 'react'
import 'react-pro-sidebar/dist/css/styles.css';
import { slide as Menu } from 'react-burger-menu'
import "../style/SidebarStyle.css"

function Sidebar(props) {
    //const type = localStorage.getItem("type");

    return (
        <Menu disableAutoFocus    >
            <a id="home" className="bm-item" href="/index" >Anasayfa</a>
            <a id="courses" className="bm-item" href="/courses"  >Dersler</a>
            <a id="contact" className="bm-item" href="/index" style={{"display":"none"}}>İletişim</a>
            <a onClick={ () => console.log() } className="menu-item--small" href="/index">Ayarlar</a>
        </Menu>
    )
}

export default Sidebar;