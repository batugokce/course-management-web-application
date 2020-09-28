import React from 'react'
import 'react-pro-sidebar/dist/css/styles.css';
import { slide as Menu } from 'react-burger-menu'
import "../style/SidebarStyle.css"

function Sidebar(props) {
    return (
        <Menu disableAutoFocus  >
            <a id="home" className="bm-item" href="/index">Anasayfa</a>
            <a id="about" className="bm-item" href="/index">Kurslar</a>
            <a id="contact" className="bm-item" href="/index">İletişim</a>
            <a onClick={ () => console.log() } className="menu-item--small" href="">Ayarlar</a>
        </Menu>
    )
}

export default Sidebar;