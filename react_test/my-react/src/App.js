import React, { Component } from 'react';

class App extends Component {
  // 상태값 정의하기(java클래스 안에서 필드를 정의하는 느낌으로 만들면 된다)
  state = {
    count: 0
  }

  // App 클래스 안에 속해있는 멤버 함수
  render() {
    // render()함수 안에서 리턴한 jsx로 화면구성이 된다
    return (
      <div>
        <h1>인덱스</h1>
        <button onClick={() => {
          const newObj = { count: this.state.count + 1 }

          this.setState(newObj);
        }}>{this.state.count}</button>
      </div>
    );
  }
}

export default App;