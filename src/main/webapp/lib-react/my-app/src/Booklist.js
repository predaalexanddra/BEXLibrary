import React, { Component } from 'react';
import Book from './Book';

class Booklist extends Component{

        // constructor(props){
        //     super(props);
        //     this.state = { posts: []};
        // }

        // componentDidMount() {
        //     console.log('here');
        //     fetch('http://localhost:3000/books')
        //         .then(response => response.json())
        //         .then(posts =>this.setState({posts}));
        // }

        render() {
            console.log(this.props.title);
            const books = this.props.title.map(book => <Book title={book.title} id={book.id} rating={book.rating}/>);
            return (
                <ul id="content">{books}</ul>
            );
        }
}

export default Booklist;