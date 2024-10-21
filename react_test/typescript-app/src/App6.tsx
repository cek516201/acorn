import axios, { AxiosRequestConfig } from "axios"
import { useEffect, useState } from "react"
import PostDto from "./interface/PostDto"

function App6() {
  const [posts, setPosts] = useState<PostDto[]>([])

  useEffect(() => {
    refresh()
  }, [])

  const refresh = () => {
    axios
      .get("/v2/posts")
      .then((res) => {
        console.log(res.data)
        setPosts(res.data as PostDto[]) // 캐스팅하면서 넣어주는게 더 안전하다
      })
      .catch((err) => console.log(err))
  }

  const [post, setPost] = useState<PostDto>({
    title: "",
    author: "",
  })

  const handleChange = (e: any) => {
    setPost({
      ...post,
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
      .post("/v2/posts", post, config)
      .then((res) => {
        console.log(res.data)
        setPosts([...posts, res.data as PostDto])
      })
      .catch((err) => console.log(err))
  }

  return (
    <div>
      <h1>post 목록</h1>
      <input onChange={handleChange} name="title" type="text" placeholder="제목 입력" />
      <input onChange={handleChange} name="author" type="text" placeholder="작성자 입력" />
      <button onClick={handleAdd}>추가</button>
      <table>
        <thead>
          <tr>
            <th>아이디</th>
            <th>제목</th>
            <th>작성자</th>
          </tr>
        </thead>
        <tbody>
          {posts.map((item: PostDto) => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>{item.title}</td>
              <td>{item.author}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}

export default App6
