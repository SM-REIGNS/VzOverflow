import React from "react";
import { Link } from "react-router-dom";
export default class logout extends React.Component {
  componentDidMount() {
    if (localStorage.getItem("token") == null) {
      this.props.history.push("/");
    }
    localStorage.clear();
    window.location.reload();
  }
  render() {
    return (
      <div className="container">
        <p> You've successfully logged out !!</p>
        <Link to="/login"> Click here to login again.</Link>
      </div>
    );
  }
}
