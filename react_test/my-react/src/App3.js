import React, { useState } from 'react';

function App3() {
    const [names, setNames] = useState(["ㅁㅁㅁ", "ㄴㄴㄴ", "ㅇㅇㅇ"])

    return (
        <div>
            <h1>배열을 state로 관리해보기</h1>

            <button onClick={()=>{
                setNames([...names, "ㄹㄹㄹ"])
                //  setNames(names.concat("ㄹㄹㄹ"))
            }}>추가</button>
            
            <ul>
                {names.map((item, index)=><li key={index}>{item}</li>)}
            </ul>
        </div>
    );
}

export default App3;