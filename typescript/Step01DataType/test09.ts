// string literal type
// 대입할 수 있는 문자열 목록을 정의할 수 있다
;(function () {
  let greet: "hi" | "bye"
  greet = "hi"
  greet = "bye"
  // greet = "asd"

  // string literal type에 별칭 부여하기
  type MouseEvent = "mousedown" | "mouseup" | "mouseover"

  let eventName: MouseEvent
  eventName = "mousedown"
  eventName = "mouseover"
  eventName = "mouseup"
})()
