import axios from "axios";
// import qs from "qs";

const baseUrl = "http://localhost:8070";

const adminService = {
  getUserByEmail(email) {
    console.log(localStorage.getItem("token"));
    return axios({
      method: "post",
      url: `${baseUrl}/admin/finduserbyemailid`,
      headers: {
        "Content-Type": "application/json",
        token: localStorage.getItem("token")
      },
      data: JSON.stringify(email)
    });
  },
  login(email, password) {
    return axios.post(`${baseUrl}/login/authenticateadmin`, {
      email,
      password
    });
  },
  addUser(user) {
    // console.log(localStorage.getItem("token"));
    // console.log(user);

    return axios({
      method: "post",
      url: `${baseUrl}/admin/adduser`,
      headers: {
        "Content-Type": "application/json",
        token: localStorage.getItem("token")
      },
      data: JSON.stringify(user)
    })
      .then(res => {
        console.log(res.data);
      })
      .catch(err => { });
  },

  removeUser(id) {
    return axios({
      method: "delete",
      url: `${baseUrl}/admin/deleteuserbyid/${id}`,
      headers: {
        "Content-Type": "application/json",
        token: localStorage.getItem("token")
      }
    })
      .then(res => {
        console.log(res.data);
      })
      .catch(err => { });
  },

  resetPasswordRequest(email) {
    return axios({
      method: "post",
      url: `${baseUrl}/admin/resetpassword`,
      headers: {
        "Content-Type": "application/json"
      },
      data: email
    }).then(res => console.log(res.data));
  }
};
export default adminService;
