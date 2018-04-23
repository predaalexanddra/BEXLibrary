import React, { Component } from 'react';
import Booklist from './Booklist';

class BookSection extends Component {

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
        // console.log(this.props.booklist)
        // const titleslist = this.props.booklist.map(post => <Booklist title={post}/>);
        // console.log(titleslist);
        //this.props.booklist.forEach(post => {console.log(post)});
        // console.log(this.props.booklist);

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