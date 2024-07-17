import React, { Component } from 'react';

class App2 extends Component {
    state = {
        count1 : 0,
        count2 : 0,
        msg : ""
    }

    clicked1 = () => {
        this.setState({count1 : this.state.count1 + 1})
    }
    clicked2 = () => {
        this.setState({count2 : this.state.count2 + 1})
    }

    render() {
        return (
            <div>
                <h1>인덱스</h1>
                <button onClick={this.clicked1}>{this.state.count1}</button>
                <button onClick={this.clicked2}>{this.state.count2}</button>
                <br/>
                <input type="text" onInput={(e)=>{
                    this.setState({
                        msg : e.target.value
                    })
                }}/>
                <p>{this.state.msg}</p>
            </div>
        );
    }
}

export default App2;