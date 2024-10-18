import Member from "./interface/Member"

function App4() {
  const m1: Member = {
    num: 1,
    name: "ㅁㅁㅁ",
    addr: "aaa",
  }
  // m1.num

  return (
    <div className="container">
      <p>interface 사용해보기</p>
      <p>{`${m1.num} ${m1.name} ${m1.addr}`}</p>
    </div>
  )
}

export default App4
