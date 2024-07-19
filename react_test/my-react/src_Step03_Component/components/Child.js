import React, { Component } from 'react';

class Child extends Component {
    render() {
        return (
            <div>
                <h3>Child Component</h3>
                <button onClick={(e) => {
                    e.target.innerText="clicked"
                }}>버튼</button>
            </div>
        );
    }
}

export default Child