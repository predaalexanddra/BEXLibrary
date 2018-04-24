import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import BookContainer from './BookContainer';
import Search from './Search';
import Login from './Login';

ReactDOM.render(<BookContainer />, document.getElementById('book__container'));
ReactDOM.render(<Search />, document.getElementById("search__div"));
ReactDOM.render(<Login />, document.getElementById("collapse1"));

