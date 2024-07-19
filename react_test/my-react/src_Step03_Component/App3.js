import React, { Component } from 'react';
import Child from './components/Child';
import Fortune from './components/Fortune';
import List from './components/List';


class App3 extends Component {
    state = {
        fortuneToday: "비가 많이 올거에요",
        names: ["ㅁㅁㅁ", "ㄴㄴㄴ", "ㅇㅇㅇ"]
    }

    clicked = () => {
        this.setState({
            fortuneToday: "비가 그칠거에요"
        })
    }

    render() {
        return (
            <div>
                <h1>인덱스</h1>
                <Child />
                <button onClick={this.clicked}>운세 변경</button>
                <Fortune data={'ㅁㅁㅁ'} />
                <Fortune data={this.state.fortuneToday} />
                <List names={this.state.names} onDelete={(idx) => {
                    const newArr = this.state.names.filter((item, index) => {
                        // if (idx === index)
                        //     return false; // 포함시키지 않음
                        // else
                        //     return true; // 포함시킴
                        return idx !== index;
                    })
                     // const newArr2 = this.state.names.filter((item, index) => idx !== index)
                    this.setState({
                        names: newArr
                    })
                }} />
            </div>
        );
    }
}

export default App3;