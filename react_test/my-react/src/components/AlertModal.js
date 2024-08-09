// src/components/Alert.js

import { Button, Modal, ModalBody } from "react-bootstrap";

//알림 모달 
function AlertModal({show, message, yes}) {
    // Modal의 show={true}면 모달이 보여지고 false면 모달이 숨겨진다
    return (
        <Modal show={show}>
            <Modal.Header>알림</Modal.Header>
            <ModalBody>{message}</ModalBody>
            <Modal.Footer>
                <Button variant="success" onClick={()=>yes()}>확인</Button>
            </Modal.Footer>
        </Modal>
    );
}

export default AlertModal;