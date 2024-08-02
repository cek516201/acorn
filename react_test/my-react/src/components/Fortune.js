import React from 'react';
import { useSelector } from 'react-redux';

function Fortune() {
    const isLogin = useSelector(state=>state.isLogin)

    return (
        <div>
            {isLogin && <p>로그인 중</p>}
            <p>오늘의 운세 : ㅁㅁㅁ</p>
        </div>
    );
}

export default Fortune;