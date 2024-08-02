import { useReducer } from "react";

const reducer = (state, action) => {
    let newState
    if (action === "minus") {
        newState = {
            ...state,
            count: state.count - 1
        }
    }
    else if (action === "plus") {
        newState = {
            ...state,
            count: state.count + 1
        }
    }
    else {
        newState = state
    }

    return newState
}

function YourCounter() {
    // [ 상태값, 상태를 변경할 때 사용할 함수 ] = useReducer(리듀서 함수, 초기값)
    const [state, dispatch] = useReducer(reducer, { count: 0 })

    return (
        <div>
            <button onClick={() => {
                // "minus" 액션을 발행해서 상태값을 변경시킨다
                dispatch("minus")
            }}>-</button>
            <strong>{state.count}</strong>
            <button onClick={() => {
                // "plus" 액션을 발행해서 상태값을 변경시킨다
                dispatch("plus")
            }}>+</button>
        </div>
    );
}

export default YourCounter;