"use strict";
;
(function () {
    function getData(item) {
        return item;
    }
    const getData2 = function (item) {
        return item;
    };
    const getData3 = (item) => {
        return item;
    };
    const result = getData(999);
    const result2 = getData("ㅁㅁㅁ");
})();
