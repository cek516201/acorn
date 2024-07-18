import React, { Component } from 'react';

class App3 extends Component {
    state = {
        names: ["ㅁㅁㅁ", "ㄴㄴㄴ", "ㅇㅇㅇ"],
        inputName: ""
    }

    getData = () => {
        const data = ["ㅂㅂㅂ", "ㅈㅈㅈ", "ㄷㄷㄷ"]
        this.setState({
            names: data
        })
    }

    addItem = () => {
        // const newArr = this.state.names.concat(this.state.inputName);
        const newArr2 = [...this.state.names, this.state.inputName]
        this.setState({
            names : newArr2
        })
    }

    render() {
        return (
            <div>
                <h3>배열을 상태값으로 가지는 예제</h3>
                <p>{this.state.names}</p>
                <button onClick={this.getData}>목록 받아오기</button>
                <br/>
                <input type="text" placeholder='이름 입력' onChange={(e) => {
                    this.setState({
                        inputName : e.target.value
                    })
                }}/>
                <button onClick={this.addItem}>추가</button>
                <ul>
                    {this.state.names.map(item => <li>{item}</li>)}
                </ul>
                {this.state.names.map(item=><li>{item}</li>)}
            </div>
        );
    }
}

export default App3;