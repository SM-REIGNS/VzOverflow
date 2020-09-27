import React from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import adminService from "../services/service";
class UpdatePassword extends React.Component {
  state = {
    password: "",
    confirmPassword: "",
    token: ""
  };

  handleSubmit = event => {
    event.preventDefault();
    adminService.resetPasswordRequest(this.state);
    this.props.history.push("/login");
  };
  handleChange = event => {
    this.setState({ [event.target.name]: event.target.value });
  };
  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <div className="form-group">
          <label htmlFor="password">Enter your new password</label>
          <input
            type="password"
            required
            className="form-control"
            name="password"
            id="password"
            onChange={this.handleChange}
          />
          <label htmlFor="confirmPassword">Confirm password</label>
          <input
            type="password"
            required
            className="form-control"
            name="confirmPassword"
            id="confirmPassword"
            onChange={this.handleChange}
          />
        </div>
        <center>
          <button type="submit" className="btn btn-primary">
            Update
          </button>
        </center>
      </form>
    );
  }
}
export default UpdatePassword;
