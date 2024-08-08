import axios from "axios";
import { useState } from "react";
import { Button, Col, Form, Row } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

function MemberForm() {
    const navigate = useNavigate()

    const [state, setState] = useState({})

    const handleChange = (e) => {
        setState({
            ...state,
            [e.target.name]: e.target.value
        })
    }

    const handleSave = () => {
        // object -> json
        axios.post("/members", state)
            .then(res => {
                // json -> object
                console.log(res.data)
                alert(res.data.name + "님의 정보 추가")
                navigate("/members")
            })
            .catch(err => console.log(err))
    }

    return (
        <>
            <h1>회원 추가 양식</h1>
            <Form>
                <Form.Group as={Row} className="mb-3" controlId="name">
                    <Form.Label column sm={2}>이름</Form.Label>
                    <Col sm={10}>
                        <Form.Control onChange={handleChange} type="text" name="name" placeholder="이름 입력" />
                    </Col>
                </Form.Group>
                <Form.Group as={Row} className="mb-3" controlId="addr">
                    <Form.Label column sm={2}>주소</Form.Label>
                    <Col sm={10}>
                        <Form.Control onChange={handleChange} type="text" name="addr" placeholder="주소 입력" />
                    </Col>
                </Form.Group>
                <Form.Group as={Row} className="mb-3">
                    <Col sm={{ span: 10, offset: 2 }}>
                        <Button onClick={handleSave} variant="primary">추가</Button>
                    </Col>
                </Form.Group>
            </Form>
        </>
    );
}

export default MemberForm;