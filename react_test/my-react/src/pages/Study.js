import React, { Component } from 'react';
import { Link, NavLink, Route, Routes, useNavigate } from 'react-router-dom';
import Eng from './Eng';
import Math from './Math';

// javascript로 route 이동을 하려면 필요한 함수
// Study component에서 this.props.navigate() 함수를 사용할 수 있도록 한다
function withNavigation(Comp){
    return props => <Comp {...props} navigate={useNavigate()} />;
}

class Study extends Component {
    render() {
        return (
            <>
                <h2>Study 페이지</h2>
                <ul>
                    <li><NavLink to="/study/math">수학공부</NavLink></li>
                    <li><NavLink to="/study/eng">영어공부</NavLink></li>
                </ul>
                <Routes>
                    <Route path='/math' Component={Math}/>
                    <Route path='/eng' Component={Eng}/>
                </Routes>
                <Link to="/">Home</Link>
                <button onClick={()=>{
                    // javascript로 이동
                    this.props.navigate("/");
                }}>Home</button>
            </>
        );
    }
}

export default withNavigation(Study);