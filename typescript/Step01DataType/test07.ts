// function도 data type이기 때문에 함수를 변수에 담을 수 있다
;(function () {
  function printMsg(msg: string): void {
    console.log(msg)
  }

  let f1 = printMsg
  let f2: (msg: string) => void = printMsg
  f2("hi")

  function printSum(num1: number, num2: number): void {
    console.log(`${num1} + ${num2} = ${num1 + num2}`)
  }

  let f3: (num1: number, num2: number) => void = printSum
  f3(1, 2)

  // 익명함수
  let f4 = function () {}
  let f5: () => void = function () {}

  let f6: (id: number, name: string) => string = function (id: number, name: string) {
    return "ok"
  }

  // 화살표함수
  let f7: (id: number, name: string) => object = (id: number, name: string) => {
    return { id, name }
  }
})()
