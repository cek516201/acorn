import React, { Component } from 'react';

class List extends Component {
    render() {
        return (
            <>
                <h3>목록</h3>
                <ul>
                    {this.props.names.map((item, index) => <li key={index}>{item} <button onClick={() => {
                        this.props.onDelete(index)
                    }}>x</button></li>)}
                </ul>
            </>
        );
    }
}

export default List;