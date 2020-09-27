import React from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import adminService from "../services/service";
class ForgotPassword extends React.Component {
  state = {
    email: ""
  };

  handleSubmit = event => {
    event.preventDefault();
    adminService.resetPasswordRequest(this.state);
    this.props.history.push("/forgotpasswordmail");
  };
  handleChange = event => {
    this.setState({ [event.target.name]: event.target.value });
  };
  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <div className="form-group">
          <label htmlFor="email">Enter your email id</label>
          <input
            type="email"
            required
            className="form-control"
            name="email"
            id="email"
            placeholder="abc@domain.com"
            onChange={this.handleChange}
          />
        </div>
        <center>
          <button type="submit" className="btn btn-primary">
            Continue
          </button>
        </center>
      </form>
    );
  }
}
export default ForgotPassword;
