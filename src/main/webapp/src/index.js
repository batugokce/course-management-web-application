import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import { BrowserRouter } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import './style/index.css'
import Root from "./Root";
ReactDOM.render(
  <BrowserRouter>
      <Root>
        <App />
      </Root>
  </BrowserRouter>
  ,
  document.getElementById('root')
);
