import React from 'react';
import {Redirect, Route} from "react-router-dom";
import Home from "./pages/Home";


function App() {
  return (
      <div className="App-intro">
        <Route path='/home' exact component={Home} />
        <Route path='/next' component={Home} />
        <Route path='/last' component={Home} />
        <Redirect to='/home' />
      </div>
  );
}

export default App;
