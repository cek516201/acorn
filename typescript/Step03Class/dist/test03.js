"use strict";
;
(function () {
    // static 필드와 메소드 정의 가능
    class MyUtil {
        static doSomething() {
            console.log("무언가 작업");
        }
    }
    MyUtil.version = "1.0";
    // static 초기화 블럭
    (() => {
        console.log("static 초기화 블럭 수행됨");
        MyUtil.version = "2.0";
    })();
    // static 필드와 메소드는 클래스명에 .을 찍어서 사용할 수 있다
    console.log(MyUtil.version);
    MyUtil.doSomething();
})();
