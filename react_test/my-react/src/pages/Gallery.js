import axios from "axios";
import { useEffect, useState } from "react";
import { Button, Card, Col, Pagination, Row } from "react-bootstrap";
import { useNavigate, useSearchParams } from "react-router-dom";

// 원하는 범위의 숫자를 배열에 담아서 리턴하는 util 함수
function range(start, end) {
    let nums = []
    for (let i = start; i <= end; i++) {
        nums.push(i)
    }

    return nums
}

function Gallery() {
    const [pageInfo, setPageInfo] = useState({
        list: []
    })

    const [pageArray, setPageArray] = useState([])
    // ?pageNum=x에서 pageNum을 추출하기 위한 hook
    // 기본값을 1로 설정
    const [params, setParams] = useSearchParams({ pageNum: 1 })

    console.log(params.get("pageNum"))

    const navigate = useNavigate()

    const refresh = (pageNum) =>
        axios.get("/gallery?pageNum=" + pageNum)
            .then(res => {
                console.log(res.data)
                setPageInfo(res.data)

                setPageArray(range(res.data.startPageNum, res.data.endPageNum))
            })
            .catch(err => { })

    // useEffect(함수, []) -> component 활성화 시점에 한번만 호출
    // useEffect(함수, [params]) -> component 활성화 시점 또는 params 값이 변경될때마다 호출
    // useEffect(함수, [state1, state2]) -> component 활성화 시점 또는 state1 or state2 값이 변경될때마다 호출
    useEffect(() => {
        const pageNum = params.get("pageNum")
        refresh(pageNum)
    }, [params])

    return (
        <>
            <h1>갤러리</h1>
            <Button onClick={() => { navigate("/gallery/new") }} variant="success">업로드</Button>
            <Row>
                {
                    pageInfo.list.map(item => (
                        <Col sm={6} md={3} key={item.num}>
                            <Card>
                                <Card.Img variant="top" src={`/upload/${item.saveFileName}`} />
                                <Card.Body>
                                    <Card.Text>{item.caption}</Card.Text>
                                    <Card.Text>writer : <strong>{item.writer}</strong></Card.Text>
                                    <Button>자세히 보기</Button>
                                </Card.Body>
                            </Card>
                        </Col>
                    ))
                }
            </Row>
            <Pagination className="mt-3">
                <Pagination.Item onClick={() => {
                    setParams({ pageNum: pageInfo.startPageNum - 1 })
                }} disabled={pageInfo.startPageNum === 1}>&laquo;</Pagination.Item>

                {
                    pageArray.map(item =>
                        <Pagination.Item onClick={() => { setParams({ pageNum: item }) }}
                            key={item} active={item === pageInfo.pageNum}>{item}</Pagination.Item>
                    )
                }

                <Pagination.Item onClick={() => {
                    setParams({ pageNum: pageInfo.endPageNum + 1 })
                }} disabled={pageInfo.endPageNum === pageInfo.totalPageCount}>&raquo;</Pagination.Item>
            </Pagination>
        </>
    );
}

export default Gallery;