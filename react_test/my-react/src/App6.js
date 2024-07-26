import React, { useState } from 'react';

function App6() {
    // string, array, number type을 상태값으로 관리하기
    const [state, setState] = useState({
        names : [],
        seq : 0
    })

    let inputName = null

    return (
        <div>
            <input ref={(refValue)=>{
                // 이 함수의 매개변수에 참조값이 전달된다
                console.log(refValue)
                inputName = refValue
            }} type="text" placeholder="이름 입력"/>

            <button onClick={()=>{
                // 버튼을 눌렀을 때 input 요소에 입력한 value를 읽어오려면 input요소의 참조값이 필요하다

                setState({
                    ...state,
                    names : [...state.names, {name : inputName.value, id : state.seq}],
                    seq : state.seq+1
                })
            }}>추가</button>
            
            <ul>
                {state.names.map(item=><li key={item.id}>{item.name}</li>)}
            </ul>
            <pre>{JSON.stringify(state, null, 2)}</pre>
        </div>
    );
}

export default App6;