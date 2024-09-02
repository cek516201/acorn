// src/pages/CafeForm.js

import { useEffect, useRef, useState } from "react";
import { Button, FloatingLabel, Form } from "react-bootstrap";
import { initEditor } from "../editor/SmartEditor";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function CafeForm() {

    //SmartEditor 에 작성한 내용을 textarea 의 value 로 넣어 줄때 필요한 함수가 editorTool 이다 
    const [editorTool, setEditorTool] = useState([])

    useEffect(() => {
        //initEditor() 함수를 호출하면서 SmartEditor 로 변환할 textarea 의 id 를 전달하면
        //textarea 가 SmartEditor 로 변경되면서 에디터 tool 객체가 리턴된다.  
        setEditorTool(initEditor("content")); // initEditor() 함수를 호출해야 SmartEditor 가 초기화된다.
    }, [])

    const inputTitle = useRef()
    const inputContent = useRef()

    const navigate = useNavigate()

    return (
        <>
            <h1>새 글 추가 양식입니다</h1>
            <Form>
                <FloatingLabel label="제목" className="mb-3" controlId="title">
                    <Form.Control ref={inputTitle} type="text" placeholder="제목 입력..." />
                </FloatingLabel>
                <Form.Group className="mb-3" controlId="content">
                    <Form.Label>내용</Form.Label>
                    <Form.Control ref={inputContent} as="textarea" rows="10" />
                </Form.Group>
                <Button type="submit" onClick={(e) => {
                    e.preventDefault();
                    editorTool.exec(); // 입력한 내용을 textarea의 value값으로 반환

                    const title = inputTitle.current.value
                    const content = inputContent.current.value

                    axios.post("/cafes", {title, content}) // json으로 전송
                    .then(res =>{
                        console.log(res.data)
                        alert("저장했습니다")
                        navigate("/cafes")
                    })
                    .catch(error => console.log(error))
                }}>저장</Button>
            </Form>
        </>
    );
}

export default CafeForm;