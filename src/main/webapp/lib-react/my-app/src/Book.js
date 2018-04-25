import React, { Component } from 'react';
import BookButon from './BookButton';

class Book extends Component {


    checkAvalability(avalability){
        if(avalability > 0){
            return <h2>Available</h2>
        } else {
            return  <h2>Unavailable</h2>
        }

    }

    putButtonIfAvailable(isLogged,idh, titleh,avail){
        if(avail >0 && isLogged)
            return <BookButon id={idh} title={titleh}  />
    }


    render() {
        // const title = this.state.posts.map(post => <h2>{post.title}</h2>);
        return (
            <li className="card">
                <div className="inside-top">
                    <div className="book__img">
                    <img id="book__img"src={"/books_img/id"+this.props.id+".jpeg"} alt="ceva"/>
                    </div>
                    <div className="book__summary">
                        <div>
                            {this.checkAvalability(this.props.avalability)}
                        </div>
                        <div>
                            <p className="book__paragraph">{this.props.title}</p>
                        </div>
                        <div className="book__button">
                            {this.putButtonIfAvailable(this.props.isLogged,this.props.id, this.props.title, this.props.avalability)}
                            {/* <BookButon id={this.props.id} title={this.props.title}/> */}
                        </div>

                    </div>
                </div>
            </li>
        );
    }
}

export default Book;
