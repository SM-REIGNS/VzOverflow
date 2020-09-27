import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { Link, Route } from "react-router-dom";
import About from "./About";
import login from "./login";
import logout from "./logout";
import Home from "./Home";
import AddUser from "./AddUser";
import ForgotPassword from "./ForgotPassword";
import ForgotPasswordMail from "./ForgotPasswordMail";
import AddUserSuccess from "./AddUserSuccess";
import RemoveUser from "./RemoveUser";
import FindUser from "./FindUser";
import UpdatePassword from "./UpdatePassword";

function App() {
  return (
    <div className="App">
      <nav className="navbar navbar-expand-sm navbar-light bg-light">
        <Link className="navbar-brand" to="/">
          Admin Portal
        </Link>
        <button
          className="navbar-toggler d-lg-none"
          type="button"
          data-toggle="collapse"
          data-target="#collapsibleNavId"
          aria-controls="collapsibleNavId"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="collapsibleNavId">
          <ul className="navbar-nav mr-auto mt-2 mt-lg-0">
            <li className="nav-item active">
              {localStorage.getItem('token') === null && <Link className="nav-link" to="/login">
                Login <span className="sr-only">(current)</span>
              </Link>}
            </li>
            <li className="nav-item active">
              {localStorage.getItem('token') === null && <Link className="nav-link" to="/about">
                About <span className="sr-only">(current)</span>
              </Link>}
            </li>
            <li className="nav-item active">
              {localStorage.getItem('token') !== null && <Link className="nav-link" to="/adduser">
                Add User <span className="sr-only">(current)</span>
              </Link>}
            </li>

            <li className="nav-item  active">
              {localStorage.getItem('token') !== null && <Link className="nav-link" to="/removeuser">
                Remove User <span className="sr-only">(current)</span>
              </Link>}
            </li>

            <li className="nav-item active">
              {localStorage.getItem('token') !== null && <Link className="nav-link" to="/finduser">
                Find User <span className="sr-only">(current)</span>
              </Link>}
            </li>

            <li className="nav-item active">
              {localStorage.getItem('token') !== null && <Link className="nav-link" to="/logout">
                Logout <span className="sr-only">(current)</span>
              </Link>}
            </li>
          </ul>
        </div>
      </nav>
      <Route path="/about" component={About} exact={true} />
      <Route path="/login" component={login} exact={true} />
      <Route path="/logout" component={logout} exact={true} />
      <Route path="/login/home" component={Home} exact={true} />
      <Route path="/finduser" component={FindUser} exact={true} />
      <Route path="/adduser" component={AddUser} exact={true} />
      <Route path="/removeuser" component={RemoveUser} exact={true} />
      <Route path="/forgotpassword" component={ForgotPassword} exact={true} />
      <Route
        path="/forgotpasswordmail"
        component={ForgotPasswordMail}
        exact={true}
      />
      <Route
        path="/updatepassword?token:id"
        component={UpdatePassword}
        exact={true}
      />
      <Route path="/addusersuccess" component={AddUserSuccess} exact={true} />
    </div>
  );
}

export default App;
