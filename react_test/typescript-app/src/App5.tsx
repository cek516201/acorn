import axios from "axios"
import { useEffect, useState } from "react"
import Member from "./interface/Member"

function App5() {
  const [data, setData] = useState<Member[]>([])

  useEffect(() => {
    axios
      .get("/members")
      .then((res) => {
        console.log(res.data)
        setData(res.data)
      })
      .catch((err) => console.log(err))
  }, [])

  return (
    <div>
      <table>
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
