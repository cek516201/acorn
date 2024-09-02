import axios from "axios";
import { useEffect, useState } from "react";
import { Button, Card, Pagination } from "react-bootstrap";
import { useSelector } from "react-redux";
import { Link, useNavigate, useParams } from "react-router-dom";
import ConfirmModal from "../components/ConfirmModal";

function GalleryDetail(props) {
    // "/gallery/:num"에서 num 읽어오기
    const { num } = useParams()
    // gallery 하나의 정보를 상태값으로 관리
    const [state, setState] = useState(null)
    const userName = useSelector(state => state.userName)

    // useEffect()에 전달한 함수는 Component가 활성화되는 시점에 1번 호출되고 num이 변경될때마다 다시 호출된다
    useEffect(() => {
        axios.get(`/gallery/${num}`)
            .then(res => {
                console.log(res.data)
                setState(res.data)
            })
            .catch(error => console.log(error))
    }, [num])

    // Confirm 모달을 띄울지 여부를 상태값으로 관리
    const [confirmShow, setConfirmShow] = useState(false)
    const navigate = useNavigate()
    const handleYes = () => {
        axios.delete(`/gallery/${num}`)
            .then(res => {
                // 삭제 후에 갤러리 목록보기로 이동
                navigate(`/gallery`)
            })
            .catch(error => console.log(error))
    }
    const handleNo = () => {
        setConfirmShow(false)
    }

    return (
        <>
            <ConfirmModal show={confirmShow} message="삭제하시겠습니까?" yes={handleYes} no={handleNo} />
            <h1>Gallery 자세히 보기</h1>
            {state && <>
                <Pagination>
                    <Pagination.Item disabled={state.prevNum === 0} as={Link} to={`/gallery/${state.prevNum}`}>&larr; prev</Pagination.Item>
                    <Pagination.Item disabled={state.nextNum === 0} as={Link} to={`/gallery/${state.nextNum}`}>next &rarr;</Pagination.Item>
                </Pagination>
                <Card>
                    <Card.Img variant="top" src={`/upload/images/${state.saveFileName}`} />
                    <Card.Body>
                        <Card.Text>{state.caption}</Card.Text>
                        <Card.Text>writer : {state.writer}</Card.Text>
                        <Card.Text>{state.regdate}</Card.Text>
                        {userName === state.writer &&
                            <Button variant="danger" onClick={() => setConfirmShow(true)}>삭제</Button>
                        }
                    </Card.Body>
                </Card>
            </>}
        </>
    );
}

export default GalleryDetail;