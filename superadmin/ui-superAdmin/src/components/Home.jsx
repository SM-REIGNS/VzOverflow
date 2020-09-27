import React from "react";
import { Link } from "react-router-dom";
class Home extends React.Component {
  render() {
    //const { user } = this.props;
    return (
      <div className="col-md-6 col-md-offset-3">
        <h1>Hi Admin!</h1>
        <p>You're logged in !!</p>
      </div>
    );
  }
}
export default Home;
