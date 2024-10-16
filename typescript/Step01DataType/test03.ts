// array type
// 데이터 type[] 형식으로 만들 수 있다

;(function () {
  let nums: number[] = [10, 20, 30]
  let names: string[] = ["ㅁㅁㅁ", "aaa"]

  nums.push(40)
  // nums.push("ㅁㅁㅁ")

  // names.push(40)
  names.push("ㅁㅁㅁ")

  // 타입추론으로 number타입으로 결정됨
  let num0 = nums[0]
  num0 = 0
  // num0 = "ㅁㅁㅁ"

  // 혼합 배열
  let anything: (number | string)[]
  anything = [10, "ㅁㅁㅁ", 20, "ㄴㄴㄴ"]
})()
