import React from 'react';
import {Redirect, Route} from "react-router-dom";
import Home from "./pages/Home";
import IndexPage from "./pages/IndexPage";


function App() {
  return (
      <div className="App-intro">
        <Route path='/home' exact component={Home} />
        <Route path='/index' component={IndexPage} />
        <Route path='/last' component={Home} />

      </div>
  );
}
//<Redirect to='/home' />
export default App;
