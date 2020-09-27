import React from "react";
import { Link } from "react-router-dom";

const About = props => {
  return (
    <div className="container">
      <div className="jumbotron">
        <h1 className="display-3">VZOVERFLOW</h1>
        <p className="lead">A platform to share knowledge</p>
        <hr className="my-2" />
        {/* <Link to='/login'><button>Login</button></Link> */}
      </div>
    </div>
  );
};
export default About;
