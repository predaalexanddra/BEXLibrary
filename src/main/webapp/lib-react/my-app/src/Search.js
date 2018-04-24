import React, { Component } from 'react';
import Booklist from './Booklist';

class Search extends Component {

    constructor() {

        super();
        this.state = {
            books: []
        };
        this.enterKeyPressed = false;
        this.showFound = this.showFound.bind(this);

    }

    onKeyDown(event) {
        if (event.key === 'Enter') {
            this.enterKeyPressed = true;
            const value = event.target.value;
            fetch(`http://localhost:8080/search?title=${value}`, {
                method: 'get'

            }).then(response => response.json())
                .then(books => {
                    // console.log(books);
                    this.setState({ books })
                    // console.log(this.state.books);
                });

        }
    }

    returnDiv(foundBooks){
        return <div className="book__section">
        <h2> Found books: </h2>
        <div className="book__selector">
            <div id="wrapper">
                <div className="module-section clearfix">
                    <Booklist title={foundBooks} />
                </div>
            </div>
        </div>
    </div>
    }

    showFound() {
        if (this.enterKeyPressed) {
            let bookEmptyList = false;
            // console.log("Je ne se quoi Jean");
            let foundBooks;
            if(this.state.books && this.state.books.length > 0){
                foundBooks = this.state.books;
                if(this.state.books[0].title){ bookEmptyList = true; }
            }else{
                foundBooks = [this.state.books];
                if(this.state.books &&  this.state.books.title){ bookEmptyList = true; }
            }
            // console.log(foundBooks);
            // console.log(typeof foundBooks);
            if (bookEmptyList) {
                return this.returnDiv(foundBooks);
            }
        }
    }

    render() {
        return (
            <div>
                <input onKeyDown={event => this.onKeyDown(event)} className="search" type="text" name="search" placeholder="Search.." />
                {this.showFound()}

            </div>

        );
    }

}

export default Search;