import React from "react";
import { Link } from "react-router-dom";
import adminService from "../services/service";
export default class RemoveUser extends React.Component {
  state = {
    Id: ""
  };
  handleSubmit = event => {
    event.preventDefault();
    adminService.removeUser(this.state.Id);
  };

  handleChange = event => {
    this.setState({ [event.target.name]: [event.target.value] });
  };

  componentDidMount() {
    if (localStorage.getItem("token") == null) {
      this.props.history.push("/login");
    }
  }
  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <div className="form-group">
          <label htmlFor="Id">Enter ID</label>
          <input
            type="text"
            className="form-control"
            name="Id"
            value={this.state.Id}
            onChange={this.handleChange}
          />
          <center>
            <button type="submit" className="btn btn-primary">
              Submit
            </button>
          </center>
        </div>
      </form>
    );
  }
}
