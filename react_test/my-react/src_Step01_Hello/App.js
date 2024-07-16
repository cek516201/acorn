import logo from './logo.svg';
import './App.css';

/*
  jsx = javascript + xml
  jsx 객체를 사용하는 표현식이 있는 파일을 jsx파일이라고 한다
  따라서 파일명을 지을때는 xxx.jsx, App.jsx로 짓는것이 정석이지만
  xxx.js로 지어도 react 개발환경에서 알아서 처리해준다
*/
function App() {
  const p1 = <p>ㅁㅁㅁ</p>
  const button1 = <button onClick={() => { alert("click") }}>버튼</button>
  const myName = "ㅁㅁㅁ"
  const myStyle = {
    color: "red",
    width: "100px",
    height: "100px",
    backgroundColor: "yellow"
  }
  const datas = [
    <li>ㅁㅁㅁ</li>,
    <li>ㄴㄴㄴ</li>,
    <li>ㄷㄷㄷ</li>
  ];
  const names = ["ㅁㅁㅁ", "ㄴㄴㄴ", "ㅇㅇㅇ"]
  const datas2 = names.map((item) => {
    return <li>{item}</li>
  });
  const datas3 = names.map(item => <li>{item}</li>);

  // jsx객체 안에서 javascript영역은 {}로 만든다
  return (
    <div className="container">
      {/* 주석 */}
      <h1>인덱스</h1>
      {p1}
      {button1}
      <p>내 이름은 <strong>{myName}</strong></p>
      <div style={{
        color: "red",
        width: "100px",
        height: "100px",
        backgroundColor: "yellow"
      }}>box</div>
      <br />
      <div style={myStyle}>box2</div>
      <ul>{datas}</ul>
      <ul>{datas2}</ul>
      <ul>{datas3}</ul>
      <ul>{names.map(item => <li>{item}</li>)}</ul>
    </div>
  );
}

export default App;
