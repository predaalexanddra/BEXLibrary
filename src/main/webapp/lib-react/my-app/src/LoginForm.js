import React, { Component } from 'react';

class LoginForm extends Component {


    doLogin(){
        fetch('http://localhost:8080/login',{
            method:'POST',
            body:JSON.stringify({username:"admin", password:"admin"})
        })
            .then(response => response.json())
            .then(posts =>{
                this.setState({posts})

            });
    }

    render(){
        return  (
            <div>
                <div id="collapse1" className="user-collapse collapse">
                    <form >
                        <input id="account-username" type="text" name="username" placeholder="user"/>
                        <input id="account-password" type="password" name="password" placeholder="password"/>
                                <button onClick={this.doLogin} className="account login__button btn btn-outline-success">Login</button>
                    </form>
                </div>
            </div>
        );
    }

}

export default LoginForm;



