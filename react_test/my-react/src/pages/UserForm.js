import { useState } from "react";
import { Button, Form } from "react-bootstrap";

function UserForm() {
    const [formData, setFormData] = useState({
        userName: "",
        password: "",
        email: ""
    });

    // 아이디, 비밀번호, 이메일을 입력했을 때 호출되는 함수
    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        })
    }

    const handleSignup = () => {

    }

    return (
        <>
            <h1>회원가입 양식</h1>
            <Form>
                <Form.Group className="mb-3" controlId="id">
                    <Form.Label>아이디</Form.Label>
                    <Form.Control onChange={handleChange} type="text" name="userName" placeholder="아이디 입력" />
                    <div className="form-text">
                        영문자로 시작하고 5~10글자 이내
                    </div>
                    <Form.Control.Feedback type="invalid">
                        사용할 수 없는 아이디입니다
                    </Form.Control.Feedback>
                </Form.Group>

                <Form.Group className="mb-3" controlId="password">
                    <Form.Label>비밀번호</Form.Label>
                    <Form.Control onChange={handleChange} type="password" name="password" placeholder="비밀번호 입력" />
                    <div className="form-text">
                        특수문자 1개 이상 포함
                    </div>
                    <Form.Control.Feedback type="invalid">
                        사용할 수 없는 비밀번호입니다
                    </Form.Control.Feedback>
                </Form.Group>

                <Form.Group className="mb-3" controlId="email">
                    <Form.Label>이메일</Form.Label>
                    <Form.Control type="email" name="email" placeholder="이메일 입력" />
                    <Form.Control.Feedback type="invalid">
                        이메일 형식에 맞게 입력해주세요
                    </Form.Control.Feedback>
                </Form.Group>

                <Button variant="primary" onClick={handleSignup}>가입</Button>
            </Form>
        </>
    );
}

export default UserForm;