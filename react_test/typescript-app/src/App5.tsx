import axios, { AxiosRequestConfig } from "axios"
import { useEffect, useState } from "react"
import Member from "./interface/Member"

function App5() {
  const [data, setData] = useState<Member[]>([])

  const refresh = () => {
    axios
      .get("/members")
      .then((res) => {
        console.log(res.data)
        setData(res.data)
      })
      .catch((err) => console.log(err))
  }

  useEffect(() => {
    refresh()
  }, [])

  const [state, setState] = useState<Member>({
    name: "",
    addr: "",
  })

  const handleChange = (e: any) => {
    setState({
      ...state,
      [e.target.name]: e.target.value,
    })
  }

  // axios 요청 설정
  const config: AxiosRequestConfig = {
    headers: {
      "Content-Type": "application/json",
    },
  }

  const handleAdd = () => {
    axios
      .post("/members", state, config)
      .then((res) => {
        console.log(res.data)
        refresh()
      })
      .catch((err) => console.log(err))
  }

  return (
    <div className="container">
      <input onChange={handleChange} name="name" type="text" placeholder="이름 입력" />
      <input onChange={handleChange} name="addr" type="text" placeholder="주소 입력" />
      <button onClick={handleAdd}>추가</button>
      <table>
        <thead>
          <tr>
            <th>번호</th>
            <th>이름</th>
            <th>주소</th>
          </tr>
        </thead>
        <tbody>
          {data.map((item: Member) => (
            <tr>
              <td>{item.num}</td>
              <td>{item.name}</td>
              <td>{item.addr}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}

export default App5
