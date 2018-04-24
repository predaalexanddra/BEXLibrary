import React, { Component } from 'react';
import Booklist from './Booklist';

class BookSection extends Component {



    render() {
       
        return (
            <div className="book__section">
                <h2> {this.props.category} </h2>
                {/* {console.log(this.props.booklist)} */}
                <div className="book__selector">
                    <div id="wrapper">
                        <div className="module-section clearfix">
                            <Booklist title={this.props.booklist} />
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default BookSection;