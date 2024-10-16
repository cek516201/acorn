// object type은 javascript의 기본 data type을 제외한 모든 type을 담을 수 있다

;(function () {
  let mem: object
  mem = {
    num: 1,
    name: "ㅁㅁㅁ",
    addr: "ㄴㄴㄴ",
  }

  let arr: object
  arr = []

  let action: object
  action = function () {}
})()
