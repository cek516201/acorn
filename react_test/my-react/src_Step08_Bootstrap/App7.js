import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.css'
import { Button, Container, Modal } from 'react-bootstrap';

function App7() {
const [isModalShow, setModalShow] = useState(false)


    return (
        <Container>
            <h3>모달 테스트</h3>
            <Button variant='success' onClick={()=>{setModalShow(true)}}>자세히보기</Button>
            <MyModal show={isModalShow} setShow={setModalShow}/>
        </Container>
    );
}

function MyModal(props) {
  
    return (
        <Modal show={props.show} onHide={()=>{props.setShow(false)}}>
          <Modal.Header closeButton>
            <Modal.Title>Modal heading</Modal.Title>
          </Modal.Header>
          <Modal.Body>Woohoo, you are reading this text in a modal!</Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={()=>{props.setShow(false)}}>
              Close
            </Button>
            <Button variant="primary" onClick={()=>{props.setShow(false)}}>
              Save Changes
            </Button>
          </Modal.Footer>
        </Modal>
    );
  }

export default App7;