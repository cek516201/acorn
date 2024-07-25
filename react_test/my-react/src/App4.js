import React, { useState } from 'react';

function App4() {
    const [isShow, setShow] = useState(true)
    const handleChange = (e)=>{
        // e.target.checked는 체크박스의 체크여부를 얻어낼 수 있다
        setShow(e.target.checked)
    }

    return (
        <div>
            <h3>check box의 체크 상태를 상태값에 반영</h3>

            <input type="checkbox" checked={isShow} onChange={handleChange}/>
            { isShow && <p>로그인 필요</p> }

            <h3>boolean, undefined, null은 렌더링되지 않는다</h3>
            <p>
                true : {true}
                <br/>
                false : {false}
                <br/>
                undefined : {undefined}
                <br/>
                null : {null}
            </p>
            <p>{ <strong>ㅁㅁㅁ</strong> }</p>
            <p>{ true && <strong>ㄴㄴㄴ</strong> }</p>
            <p>{ false && <strong>ㅇㅇㅇ</strong> }</p>
        </div>
    );
}

export default App4;