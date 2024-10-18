import { useState } from "react"

function App() {
  const myName: string = "ㅁㅁㅁ"

  const [count, setCount] = useState<number>(0)

  const handleClick = () => {
    setCount(count + 1)
  }

  const handleClick2 = (e: any) => {
    e.target.innerText += "튼"
  }

  return (
    <div className="container">
      <p>
        내 이름 : <strong>{myName}</strong>
      </p>
      <button onClick={handleClick}>{count}</button>
      <button onClick={handleClick2}>버튼</button>
    </div>
  )
}

export default App
