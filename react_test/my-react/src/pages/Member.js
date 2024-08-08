import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';
import { Table } from 'react-bootstrap';

function Member() {
    const navigate = useNavigate()

    // 회원목록 상태값 관리
    const [members, setMembers] = useState([])

    const refresh = () => {
        axios.get("/members")
            .then(res => setMembers(res.data))
            .catch(err => console.log(err))
    }

    // Member component가 활성화되는 시점에 호출되는 함수 등록
    // useEffect(함수, 빈 배열) 함수는 component가 활성화 될 때 최초 1번 호출(개발환경은 2번)
    useEffect(() => {
        refresh()
    }, [])

    const handleDelete = (num) => {
        axios.delete("/members/" + num)
            .then(res => {
                if (res.data.isSuccess) {
                    refresh()
                }
            })
            .catch(err => console.log(err))
    }

    return (
        <>
            <Link to="/members/new">회원 추가</Link>
            <h1>회원 목록</h1>
            <Table striped bordered size="sm">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>이름</th>
                        <th>주소</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {members.map(item => <tr key={item.num}>
                        <td>{item.num}</td>
                        <td>{item.name}</td>
                        <td>{item.addr}</td>
                        <td><button onClick={() => {
                            navigate(`/members/${item.num}/edit`)
                        }}>수정</button></td>
                        <td><button onClick={() => handleDelete(item.num)}>삭제</button></td>
                    </tr>)}
                </tbody>
            </Table>
        </>
    );
}

export default Member;