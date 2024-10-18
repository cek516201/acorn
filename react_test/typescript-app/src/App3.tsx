import { useRef } from "react"

function App3() {
  const handleClick = () => {
    if (ref.current) {
      ref.current.innerText += "누름"
    }
  }

  const ref = useRef<HTMLParagraphElement>(null) // {current: x} x의 초기값은 null인데 p요소가 만들어지면 값이 설정된다

  return (
    <div className="container">
      <button onClick={handleClick}>버튼</button>
      <p ref={ref}></p>
    </div>
  )
}

export default App3
