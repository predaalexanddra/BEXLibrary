import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import BookContainer from './BookContainer';
import LoginForm from './LoginForm';

ReactDOM.render(<BookContainer />, document.getElementById('book__container'));
ReactDOM.render(<LoginForm />, document.getElementById('login_form'));

