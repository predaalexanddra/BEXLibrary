import React, { Component } from 'react';
import BookSection from './BookSection';

class BookContainer extends Component{

    constructor(props){
        super(props);
        this.state = {
            isLogged : false,
            posts: []
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
    debug(isLogged){
        this.setState({isLogged: isLogged})
    }

    componentDidMount() {
        fetch('http://localhost:8080/categories')
            .then(response => response.json())
            .then(posts =>{
                this.setState({posts})

            });
    }

    render() {
        const booksections = this.state.posts.map(post =>  <BookSection isLogged= {this.state.isLogged} booklist={post.booklist} category={post.categoryName}  />);
        return (
            <div id="content" className="book__section">
                {booksections}
            </div>
        );
    }
}

export default BookContainer;