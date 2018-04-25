import React, { Component } from 'react';
import Cookies from 'universal-cookie';

class Login extends Component {

    constructor() {
        // const cookies = new Cookies();
        super();
        this.state = {
            email: '',
            pass: '',
            isLogged : false
        };
        this.checkIfIsLoggedIn();

    }

    checkIfIsLoggedIn(){
        fetch('http://localhost:8080/isLoggedIn')
            .then(response => response.json())
            .then(isLogged => {
                console.log(isLogged);
                this.debug(isLogged)
            });
    }

    debug(response){
        this.setState({isLogged: response})
    }



    doLogin(account) {
        // this.cookies.set('email', 'andrei', { path: '/' })
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
                      window.location.reload();
                        break;
            default:
                alert('Incorrect username or password! Please provide the proper credentials for authentication.');
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
            <p id="loggedIn">{this.state.email}</p>
            <button className="logout__btn" onClick={event => this.changeLoginState(event)}>LOGOUT</button>
        </div>);
    }

    notLoggeInTab(){
        return(
        <div className = "login__button__react">
            <input className="account user" type="text" name="firstname" placeholder="user" onChange={event => this.setUserEmail(event)} />
            <input className="account password" type="password" name="firstname" placeholder="password" onChange={event => this.setUserPassword(event)} />
            <button className="account login__button" onClick={event => this.loginSubmit(event)}>LOGIN</button>
        </div>);
    }

    changeLoginState(event){
        fetch('http://localhost:8080/logOut');
        this.setState({
            email: '',
            pass: '',
            isLogged : false
        })
        window.location.reload()
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