"use strict";
;
(function () {
    // interface도 type이다
    let m1 = {
        num: 1,
        name: "ㅁㅁㅁ",
        isMan: true,
    };
    let p1 = {
        firstname: "ㅁㅁㅁ",
        lastname: "ㄴㄴㄴ",
        email: "@",
    };
    let p2 = {
        firstname: "aaa",
        lastname: "sss",
    };
    const t1 = {
        id: 1,
        content: "공부하기",
    };
    // readonly는 읽기 전용이기때문에 수정 불가
    // t1.id = 2
    t1.content = "잠자기";
})();
