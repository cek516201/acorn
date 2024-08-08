import axios from "axios";
import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

function Post() {
    const navigate = useNavigate()

    const [posts, setPosts] = useState([])

    const refresh = () => {
        axios.get("/posts")
            .then(res => setPosts(res.data))
            .catch(err => console.log(err))
    }

    // Member component가 활성화되는 시점에 호출되는 함수 등록
    // useEffect(함수, 빈 배열) 함수는 component가 활성화 될 때 최초 1번 호출(개발환경은 2번)
    useEffect(() => {
        refresh()
    }, [])

    return (
        <>
            <Link to="/posts/new">추가</Link>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>저자</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {
                        posts.map(item => <tr key={item.id}>
                            <td>{item.id}</td>
                            <td>{item.title}</td>
                            <td>{item.author}</td>
                            <td><button onClick={() => {
                                navigate(`/posts/${item.id}/edit`)
                            }}>수정</button></td>
                        </tr>)
                    }
                </tbody>
            </table>
        </>
    );
}

export default Post;