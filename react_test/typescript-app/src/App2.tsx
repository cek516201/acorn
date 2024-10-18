import { useState } from "react"

function App2() {
  const [msgs, setMsgs] = useState<string[]>([])

  const [msg, setMsg] = useState<string>("")

  const handleClick = () => {
    setMsgs([...msgs, msg])
    setMsg("")
  }

  const handleChange = (e: any) => {
    setMsg(e.target.value)
  }

  return (
    <div className="container">
      <input type="text" onChange={handleChange} value={msg} />
      <button onClick={handleClick}>추가</button>
      <ul>
        {msgs.map((item) => (
          <li>{item}</li>
        ))}
      </ul>
    </div>
  )
}

export default App2
