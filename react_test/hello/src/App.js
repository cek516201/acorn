import './App.css';

function App() {
  const myName = "ㅁㅁㅁ"
  const clicked = () => {
    alert("onClick2")
  }

  return (
    <div className="container">
      <h1>인덱스</h1>
      <p>내 이름은 <strong>{myName}</strong></p>
      <button onClick={() => { alert("onClick") }}>버튼</button>
      <button onClick={clicked}>버튼2</button>
    </div>
  );
}

export default App;
