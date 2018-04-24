import React, { Component } from 'react';
import BookButon from './BookButton';

class Book extends Component {

    // constructor(props) {
    //     super(props);
    //     // this.state = { posts: []}; // {}
    // }

    // componentDidMount() {
    //     console.log('here');
    //     fetch('http://localhost:3000/books')
    //         .then(response => response.json())
    //         .then(posts =>this.setState({posts}));
    // }

    render() {
        // const title = this.state.posts.map(post => <h2>{post.title}</h2>);
        return (
            <li className="card">
                <div className="inside-top">
                    <div className="book__img">
                        <img src="/img/book.jpg" alt="ceva"/>
                    </div>
                    <div className="book__summary">
                        <h2 className="book__rating">{this.props.rating ? this.props.rating : '0.0'}</h2>
                        <p className="book__paragraph">{this.props.title}</p>
                        <div className="book__button">
                            <BookButon id={this.props.id} title={this.props.title}  />
                        </div>
                    </div>
                </div>
            </li>
        );
    }
}

export default Book;
