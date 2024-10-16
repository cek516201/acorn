var __assign = (this && this.__assign) || function () {
    __assign = Object.assign || function(t) {
        for (var s, i = 1, n = arguments.length; i < n; i++) {
            s = arguments[i];
            for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p))
                t[p] = s[p];
        }
        return t;
    };
    return __assign.apply(this, arguments);
};
var num;
num = 10;
console.log(num);
var obj = { num: 1, name: "ㅁㅁㅁ" };
var result = __assign(__assign({}, obj), { addr: "ㄴㄴㄴ" });
