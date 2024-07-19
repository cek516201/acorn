
import { Component } from 'react';
import './App.css' // 모든 컴포넌트에서 사용할 css

//클래스형 component
class App extends Component{

 
  render(){

    return (
      <div className="container">
        <h1>인덱스 페이지 입니다</h1>
        <div className="box">asd</div>
      </div>
    )
  }
}

export default App;