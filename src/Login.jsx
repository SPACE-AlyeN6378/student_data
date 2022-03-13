import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.css';

class Login extends Component {

    constructor(props) {
        super(props);
        this.state = {
            input_email: "",
            input_pwd: ""
        }
    }

    handleSubmit = (event) => {
        this.props.appChangeState(this.state.input_email);
        event.preventDefault(); 
    }
    
    
    render() { 

        return (
            <div>
                <br></br>
                <div className="container">
                    <div className='row'>
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h1 className='p-4'>Login</h1>
                            <div className='card-body'>
                                <form onSubmit={this.handleSubmit}>
                                    <div>
                                        <label>Email ID: </label>
                                        <input 
                                            className='form-control'
                                            placeholder='helloworld@example.com'
                                            type="text"
                                            name="email"
                                            value={this.state.input_email}
                                            onChange={(e) => this.setState({input_email: e.target.value})}
                                            required />
                                    </div>
                                    <div>
                                        <label>Password: </label>
                                        <input 
                                            className='form-control'
                                            placeholder='Password'
                                            type="password"
                                            name="pwd"
                                            value={this.state.input_pwd}
                                            onChange={(e) => this.setState({input_pwd: e.target.value})}
                                            required />
                                    </div>
                                    <div>
                                        <input type='submit' className='button btn-outline-success m-3' name='Sign In' />
                                        <a href='#'>Register</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                
                   
            
                
        );  
    }
}
 
export default Login;