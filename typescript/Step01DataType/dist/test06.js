"use strict";
// function type
// 함수 만드는 방법
;
(function () {
    // number type 2개를 전달받아서 number type을 리턴해주는 함수
    function sum(num1, num2) {
        return num1 + num2;
    }
    function printMsg(msg) {
        console.log(msg);
    }
    // return type을 명시하지 않으면 return type을 추론한다
    function getMsg() {
        return "hello";
    }
    // result는 string type으로 추론한다
    let result = getMsg();
    // result = 10
})();
