// src/components/BsNavBar.js

import { Button, Container, Nav, Navbar } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import { NavLink, useNavigate } from "react-router-dom";
import { useState } from "react";
import AlertModal from "./AlertModal";

function BsNavBar() {
    //로그인된 사용자명이 있는지 store 에서 읽어와 본다.
    const userName = useSelector(state => state.userName)
    // action 을 dispatch 할수 있는 함수 
    const dispatch = useDispatch()
    const navigate = useNavigate()

    const [alertShow, setAlertShow] = useState(false)

    const hanndleLogout = () => {
        delete localStorage.token
        dispatch({ type: "UPDATE_USER", payload: null })
        navigate("/")
        setAlertShow(true)
    }

    const handleYes = () => { setAlertShow(false) }

    return (
        <>
            <AlertModal show={alertShow} message="로그 아웃" yes={handleYes} />
            <Navbar expand="md" className="bg-warning mb-2">
                <Container>
                    <Navbar.Brand as={NavLink} to="/">Acorn</Navbar.Brand>
                    <Navbar.Toggle aria-controls="one" />
                    <Navbar.Collapse id="one">
                        <Nav className="me-auto">
                            <Nav.Link as={NavLink} to="/">Home</Nav.Link>
                            <Nav.Link as={NavLink} to="/members">Member</Nav.Link>
                            <Nav.Link as={NavLink} to="/posts">Post</Nav.Link>
                            <Nav.Link as={NavLink} to="/gallery">Gallery</Nav.Link>
                        </Nav>
                        {userName ?
                            <>
                                <Nav>
                                    <Nav.Link>{userName}</Nav.Link>
                                    <span className="navbar-text">Signed in</span>
                                </Nav>
                                <Button variant="outline-primary" onClick={hanndleLogout}>Logout</Button>
                            </>
                            :
                            <Button variant="success" onClick={() => {
                                //로그인 모달을 띄우는 action 을 dispatch 한다 
                                const action = {
                                    type: "LOGIN_MODAL",
                                    payload: {
                                        show: true,
                                        message: "로그인 폼 입니다"
                                    }
                                }
                                dispatch(action)
                            }}>Sign in</Button>
                        }
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </>
    );
}

export default BsNavBar;