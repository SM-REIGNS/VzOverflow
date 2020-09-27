import React from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import adminService from "../services/service";
class AddUser extends React.Component {
  componentDidMount() {
    if (localStorage.getItem("token") == null) {
      this.props.history.push("/login");
    }
  }
  state = {

    firstName: "",
    middleName: "",
    lastName: "",
    id: "",
    role: "",
    designation: "",
    qualification: "",
    dateOfBirth: "",
    dateOfJoining: "",
    department: "",
    // address: {
    addressLine1: "",
    addressLine2: "",
    city: "",
    pincode: "",
    country: "",
    // },
    // contact: {
    email: "",
    phoneNo: ""
    // }
  };
  handleChange = event => {
    this.setState({ [event.target.name]: event.target.value });
  };
  handleSubmit = event => {
    event.preventDefault();
    const user = this.state;
    adminService.addUser(user);
    console.log(user)
    this.props.history.push("/addusersuccess");

    // console.log(user);
  };
  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <div className="form-group">
          <label htmlFor="firstName">First Name</label>
          <input
            type="text"
            className="form-control"
            name="firstName"
            value={this.state.firstName}
            onChange={this.handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="middleName">Middle Name</label>
          <input
            type="text"
            className="form-control"
            name="middleName"
            value={this.state.middleName}
            onChange={this.handleChange}
          // required
          />
        </div>
        <div className="form-group">
          <label htmlFor="lastName">Last Name</label>
          <input
            type="text"
            className="form-control"
            name="lastName"
            value={this.state.lastName}
            onChange={this.handleChange}
          // required
          />
        </div>
        <div className="form-group">
          <label htmlFor="Id">Employee id</label>
          <input
            type="text"
            className="form-control"
            name="id"
            value={this.state.id}
            onChange={this.handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="role">Role</label>
          <input
            type="text"
            className="form-control"
            name="role"
            value={this.state.role}
            onChange={this.handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="designation">Designation</label>
          <input
            type="text"
            className="form-control"
            name="designation"
            value={this.state.designation}
            onChange={this.handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="qualification">qualification</label>
          <input
            type="text"
            className="form-control"
            name="qualification"
            value={this.state.qualification}
            onChange={this.handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="dateOfBirth">Date Of Birth</label>
          <input
            type="text"
            className="form-control"
            name="dateOfBirth"
            value={this.state.dateOfBirth}
            onChange={this.handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="dateOfJoining">Date Of Joining</label>
          <input
            type="text"
            className="form-control"
            name="dateOfJoining"
            value={this.state.dateOfJoining}
            onChange={this.handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="department">department</label>
          <input
            type="text"
            className="form-control"
            name="department"
            value={this.state.department}
            onChange={this.handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="email">emailId</label>
          <input
            type="email"
            className="form-control"
            name="email"
            value={this.state.email}
            onChange={this.handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="phoneNo">Mobile Number</label>
          <input
            type="text"
            className="form-control"
            name="phoneNo"
            value={this.state.phoneNo}
            onChange={this.handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="addressLine1">addressLine1</label>
          <input
            type="text"
            className="form-control"
            name="addressLine1"
            value={this.state.addressLine1}
            onChange={this.handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="addressLine2">addressLine2</label>
          <input
            type="text"
            className="form-control"
            name="addressLine2"
            value={this.state.addressLine2}
            onChange={this.handleChange}
          />
        </div>
        <div className="form-group">
          <label htmlFor="city">city</label>
          <input
            type="text"
            className="form-control"
            name="city"
            value={this.state.city}
            onChange={this.handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="pincode">pincode</label>
          <input
            type="text"
            className="form-control"
            name="pincode"
            value={this.state.pincode}
            onChange={this.handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="country">country</label>
          <input
            type="text"
            className="form-control"
            name="country"
            value={this.state.country}
            onChange={this.handleChange}
            required
          />
        </div>
        <div className="form-group">
          <button className="btn btn-primary" type="submit">
            Add user
          </button>
          <Link to="/login/home" className="btn btn-link">
            Cancel
          </Link>
        </div>
      </form>
    );
  }
}
export default AddUser;
