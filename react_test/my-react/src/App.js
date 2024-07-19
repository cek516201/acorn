
import { Component } from 'react';
import './App.css'

//클래스형 component
class App extends Component {
  state = {
    posts: []
  }

  // App컴포넌트가 준비완료 되었을 때 최초 한번 호출
  componentDidMount() {
    this.getPosts()
  }

  getPosts = () => {
    fetch("/posts")
      .then(res => res.json())
      .then(data => {
        this.setState({
          posts: data
        })
      })
  }

  render() {

    return (
      <div className="container">
        <form action="/posts" method="post" onSubmit={(e) => {
          e.preventDefault()
          // 요청 url
          const url = e.target.action;
          // 전송할 폼 데이터
          const formData = new FormData(e.target)
          const queryString = new URLSearchParams(formData).toString();
          fetch(url, {
            method: "post",
            headers: { "Content-Type": "application/x-www-form-urlencoded; charset=utf-8" },
            body: queryString
          })
            .then(res => res.json())
            .then(data => {
              alert(data.id + "번 post로 등록 되었습니다")
              this.getPosts()
            })
            .catch(error => {
              console.log("에러 발생", error)
            })
        }}>
          <input type="text" name="title" placeholder="제목 입력" />
          <input type="text" name="author" placeholder="작성자 입력" />
          <button type="submit">저장</button>
        </form>

        <button onClick={() => {
          this.getPosts()
        }}>요청하기</button>

        <h3>글 목록</h3>
        <table>
          <thead>
            <tr>
              <th>번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th></th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            {this.state.posts.map(item =>
              <tr key={item.id}>
                <td>{item.id}</td>
                <td>{item.title}</td>
                <td>{item.author}</td>
                <td><button onClick={() => {
                  const title = prompt(item.id + "번 글의 수정할 제목 입력")
                  // 수정할 정보를 FormData 객체에 담는다
                  const formData = new FormData()
                  formData.append("title", title)
                  formData.append("author", item.author)
                  const queryString = new URLSearchParams(formData).toString();

                  fetch("/posts/" + item.id, {
                    method: "put",
                    headers: { "Content-Type": "application/x-www-form-urlencoded; charset=utf-8" },
                    body: queryString
                  })
                    .then(res => res.json())
                    .then(data => {
                      this.getPosts()
                    })
                }}>수정</button></td>

                <td><button onClick={() => {
                  fetch("/posts/" + item.id, {
                    method: "delete"
                  })
                    .then(res => res.json())
                    .then(data => {
                      this.getPosts()

                      // this.setState({
                      //   posts: this.state.posts.filter(it => data.id !== it.id)
                      // })
                    })
                }}>삭제</button></td>
              </tr>)}
          </tbody>
        </table>
      </div>
    )
  }
}

export default App;