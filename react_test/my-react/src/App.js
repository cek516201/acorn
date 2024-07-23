
import { Component } from 'react';
import './App.css'
import axios from "axios";

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
    /*
      axios가 get방식 "/posts" 요청을 대신 해준다
      응답되는 json 문자열을 실제 array or object로 변경을 해서
      then() 함수 안에 전달한 함수의 매개변수 res에 넣어준다
      res는 object이고 res의 data라는 방에 array or object가 들어있다
    */
    axios.get("/posts")
    .then((res)=>{
      this.setState({
        posts: res.data
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
          // FormData에 들어있는 내용을 이용해서 json 문자열 만들어내기
          const formObject={}
          formData.forEach((value, key)=>{
            formObject[key]=value
          })

          // const jsonString = JSON.stringify(formObject)
          /*
            object를 json 문자열로 변경할 필요 없이 object를 두번째 인자로 전달하거나
            query문자열을 전달하면 된다

            axios.post(요청 url, object or query 문자열)
          */
          axios.post(url, formObject)
          .then((res)=>{
            alert(res.data.id + "번 post로 등록 되었습니다")
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
                  // 수정할 정보를 object에 담는다
                  const obj = {
                    title : title,
                    author : item.author
                  }

                  // object를 이용해서 json문자열을 얻어낸다
                  // const jsonString = JSON.stringify(obj)
                  axios.put("/posts/" + item.id, obj)
                  .then((res)=>{
                    this.getPosts()
                  })
                }}>수정</button></td>

                <td><button onClick={() => {
                  axios.delete("/posts/" + item.id)
                  .then((res)=>{
                    this.getPosts()

                    // this.setState({
                    //   posts: this.state.posts.filter(it => res.data.id !== it.id)
                    // })
                  })
                  .catch((err)=>{
                    console.log(err)
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