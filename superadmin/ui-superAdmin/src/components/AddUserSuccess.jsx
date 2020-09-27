import React from "react";
import { Link } from "react-router-dom";
class AddUserSuccess extends React.Component {
  render() {
    //const { user } = this.props;
    return (
      <div className="col-md-6 col-md-offset-3">
        <h1>Hi Admin!</h1>
        <p>User Added Successfuollly</p>
        <p>
          <Link to="/login/home">Back to home page</Link>
        </p>
      </div>
    );
  }
}
export default AddUserSuccess;
