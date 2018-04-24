import React, { Component } from 'react';
// import cookie from 'react-cookie';

class Login extends Component {

    constructor() {
        super();
        this.state = {
            // userId : cookie.load("onboarded"),
            email: '',
            pass: '',
            isLogged : false
        }
    }

    doLogin(account) {
        fetch('http://localhost:8080/login', {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(account)
        })
            .then(response => this.processLoginResponse(response.status));
    }

    processLoginResponse(status) {
        switch(status) {
            case 200: this.setState({isLogged: true});
                        break;
            default: 
                alert('Incorrect username or password');
        }
    }

    setUserEmail(event) {
        const email = event.target.value;
        this.setState({ email: email });
    }

    setUserPassword(event) {
        const password = event.target.value;
        this.setState({ pass: password });
    }


    loginSubmit(event) {
        const account = {
            userEmail: this.state.email,
            password: this.state.pass
        };
        this.doLogin(account);

    }

    isLoggedIn(){
        if(!this.state.isLogged){
            return this.notLoggeInTab();
        } else {
            return this.logInTab();
        }
    }

    logInTab(){
        return(
        <div>
            <button onClick={event => this.changeLoginState(event)}>LOGOUT</button>
        </div>);
    }

    notLoggeInTab(){
        return(
        <div>
            <input class="account user" type="text" name="firstname" placeholder="user" onChange={event => this.setUserEmail(event)} />
            <input class="account password" type="password" name="firstname" placeholder="password" onChange={event => this.setUserPassword(event)} />
            <button class="account login__button" onClick={event => this.loginSubmit(event)}>LOGIN</button>
        </div>);
    }

    changeLoginState(event){
        this.setState({
            email: '',
            pass: '',
            isLogged : false
        })
    }

    render() {
        return (
            <div>
                {this.isLoggedIn()}
            </div>
           
        );
    }

}

export default Login;