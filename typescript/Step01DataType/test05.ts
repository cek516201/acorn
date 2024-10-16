// any type
// java의 object와 비슷한 type
;(function () {
  let anything: any

  anything = 10
  anything = "kim"
  anything = true

  // json 문자열을 파싱하면 any type이 리턴된다
  let json: string = `
    {
        "num" : 1,
        "name" : "ㅁㅁㅁ",
        "isMan" : true
    }`

  let result: any = JSON.parse(json)
})()
