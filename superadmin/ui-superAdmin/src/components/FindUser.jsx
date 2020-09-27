import React from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import adminService from "../services/service";
export default class FindUser extends React.Component {
  componentDidMount() {
    if (localStorage.getItem("token") == null) {
      this.props.history.push("/login");
    }
  }

  state = {
    email: "",
    isFetched: false,
    user: {
      firstName: "",
      middleName: "",
      lastName: "",
      Id: "",
      role: "",
      designation: "",
      qualification: "",
      dateOfBirth: "",
      dateOfJoining: "",
      department: "",
      address: {
        addressLine1: "",
        addressLine2: "",
        city: "",
        pincode: "",
        country: ""
      },
      contact: {
        emailId: "",
        phoneNo: ""
      }
    }
  };

  generalUi = (
    <form onSubmit={this.handleSubmit}>
      <div className="form-group">
        <label htmlFor="email">Enter user's email id</label>
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

  successUi = (
    <div className="container">
      <h3>{this.state.user.Id}</h3>
      <p>{this.state.user.firstName}</p>
      <p>{this.state.user.middleName}</p>
      <p>{this.state.user.lastName}</p>
      <p>{this.state.user.contact.emailId}</p>
      <p>{this.state.user.contact.phoneNo}</p>
      {/* <p>{this.state.user.firstName}</p>
              <p>{this.state.user.firstName}</p> */}
    </div>
  );

  handleSubmit = event => {
    event.preventDefault();
    console.log("hello");
    console.log(this.state.email);
    adminService.getUserByEmail(this.state.email).then(res => {
      console.log(res);
      this.setState({
        ...this.state,
        user: res.data,
        isFetched: true
      });
    });
    // this.props.history.push("/forgotpasswordmail");
  };
  handleChange = event => {
    this.setState({ [event.target.name]: event.target.value });
    console.log(this.state.email);
  };
  render() {
    let ui;
    switch (this.state.isFetched) {
      case false:
        ui = this.generalUi;
        break;

      case true:
        ui = this.successUi;
        break;
    }
    return (
      <div className="container">
        <form onSubmit={this.handleSubmit}>
          <div className="form-group">
            <label htmlFor="email">Enter user's email id</label>
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
      </div>
    );
  }
}
