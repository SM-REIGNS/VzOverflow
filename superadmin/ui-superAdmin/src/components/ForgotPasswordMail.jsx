import React from 'react';
import { Link } from "react-router-dom";
class ForgotPasswordMail extends React.Component {
    render() {

        return (
            <div>
                A mail has been sent to your registered email.
                <br />
                <Link to='/login'><button type="submit" className="btn btn-primary">Back to login page</button></Link>
            </div>
        )
    }
}
export default ForgotPasswordMail