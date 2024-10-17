"use strict";
// function도 data type이기 때문에 함수를 변수에 담을 수 있다
;
(function () {
    function printMsg(msg) {
        console.log(msg);
    }
    let f1 = printMsg;
    let f2 = printMsg;
    f2("hi");
    function printSum(num1, num2) {
        console.log(`${num1} + ${num2} = ${num1 + num2}`);
    }
    let f3 = printSum;
    f3(1, 2);
    // 익명함수
    let f4 = function () { };
    let f5 = function () { };
    let f6 = function (id, name) {
        return "ok";
    };
    // 화살표함수
    let f7 = (id, name) => {
        return { id, name };
    };
})();
