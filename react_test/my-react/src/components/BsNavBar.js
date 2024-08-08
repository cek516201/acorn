import { Button, Container, Nav, Navbar } from "react-bootstrap"
import { useSelector } from "react-redux";
import { NavLink } from "react-router-dom";

function BsNavBar() {
    // 로그인된 사용자명이 있는지 store에서 읽어와본다
    const userName = useSelector(state => state.userName)

    return (
        <Navbar expand="md" className="bg-warning mb-2">
            <Container>
                <Navbar.Brand as={NavLink} to="/">Acorn</Navbar.Brand>
                <Navbar.Toggle aria-controls="one" />
                <Navbar.Collapse id="one">
                    <Nav className="me-auto">
                        <Nav.Link as={NavLink} to="/">Home</Nav.Link>
                        <Nav.Link as={NavLink} to="/members">Member</Nav.Link>
                        <Nav.Link as={NavLink} to="/posts">Post</Nav.Link>
                    </Nav>
                    {
                        userName ?
                        <>
                            <Nav>
                                <Nav.Link>{userName}</Nav.Link>
                                <span className="navbar-text">Signed in</span>
                            </Nav>
                            <Button variant="outline-primary">Log out</Button>
                        </>
                        :
                        <Button variant="success">Sign in</Button>
                    }
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}

export default BsNavBar;