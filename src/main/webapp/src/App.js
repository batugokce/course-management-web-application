import React from 'react';
import {Route} from "react-router-dom";
import Home from "./pages/Home";
import IndexPage from "./pages/IndexPage";
import CoursePage from "./pages/CoursePage";
import CourseDetailPage from "./pages/CourseDetailPage";


function App() {
  return (
      <div className="App-intro">
        <Route path='/home' exact component={Home} />
        <Route path='/index' component={IndexPage} />
        <Route path='/courses' component={CoursePage} />
        <Route path='/course/:id' render={(props) => {
              return ( <CourseDetailPage {...props } /> )
          }} />

      </div>
  );
}
//<Redirect to='/home' />
export default App;
