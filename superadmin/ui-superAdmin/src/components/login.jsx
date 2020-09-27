import React from "react";
import { Link, Redirect } from "react-router-dom";
import adminService from "../services/service";
import jwt_decode from "jwt-decode";
// var jwtDecode = require("jwt-decode");
class login extends React.Component {
  state = {
    email: "",
    password: "",
    isSubmitted: false
  };

  handleSubmit = event => {
    event.preventDefault();
    adminService
      .login(this.state.email, this.state.password)
      .then(
        res => {
          // console.log("hello", res.headers["token"]);
          return res.headers["token"];
        },
        err => {
          alert("incorrect username and password");
          window.location.reload();
        }
      )
      .then(token => {
        var decoded_token = jwt_decode(token);
        if (decoded_token.role !== "admin") {
          localStorage.clear();
          alert("Invalid Login Credentials");
          this.props.history.push("/login");
        } else {
          localStorage.setItem("token", token);
          // console.log(token, localStorage.getItem("token"));
          this.props.history.push("/about");

          window.location.reload()

        }
      });
  };
  handleChange = event => {
    this.setState({ [event.target.name]: event.target.value });
  };

  render() {
    return (
      <div className="container">
        <form method="post" onSubmit={this.handleSubmit}>
          <div className="form-group">
            <label htmlFor="email">Email</label>
            <input
              type="email"
              required
              className="form-control"
              name="email"
              id="email"
              placeholder="Email Id"
              onChange={this.handleChange}
            />
          </div>
          <div className="form-group">
            <label htmlFor="password">Password</label>
            <input
              type="password"
              required
              className="form-control"
              name="password"
              id="password"
              placeholder="Password"
              onChange={this.handleChange}
            />
          </div>
          <center>
            <button type="submit" className="btn btn-primary">
              Submit
            </button>
            &nbsp;
            <Link to="/forgotpassword">
              <button type="submit" className="btn btn-primary">
                forgot Password
              </button>
            </Link>
          </center>
        </form>
      </div>
    );
  }
}
export default login;
