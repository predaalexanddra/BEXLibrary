import React, { Component } from 'react';
import BookSection from './BookSection';

class BookContainer extends Component{

        constructor(props){
            super(props);
            this.state = {posts: []};
        }

        componentDidMount() {
            fetch('http://localhost:8080/booksbycateg')
                .then(response => response.json())
                .then(posts =>{ 
                    this.setState({posts})
                    
                });
        }

        render() {
            const booksections = this.state.posts.map(post =>  <BookSection booklist={post.booklist} category={post.categoryName}  />);
            return (
                <div id="content" className="book__section">
                    {booksections}
                </div>
            );
        }
}

export default BookContainer;