"use strict";
// any type
// java의 object와 비슷한 type
;
(function () {
    let anything;
    anything = 10;
    anything = "kim";
    anything = true;
    // json 문자열을 파싱하면 any type이 리턴된다
    let json = `
    {
        "num" : 1,
        "name" : "ㅁㅁㅁ",
        "isMan" : true
    }`;
    let result = JSON.parse(json);
})();
