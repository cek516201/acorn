// type 별칭 부여하기
;(function () {
  // string type을 Name type으로 사용하겠다
  type Name = string

  const firstName: Name = "ㅁㅁㅁ"
  const lastName: Name = "ㄴㄴㄴ"

  type MemberDto = {
    num: number
    name: string
    addr: string
  }

  const m1: MemberDto = {
    num: 1,
    name: "123",
    addr: "qwe",
  }

  // number과 string의 합집합 type
  type NumString = number | string
  let data: NumString = 1
  data = "ㅁㅁㅁ"
})()
;(function () {
  type Person = {
    name: string
    age: number
  }

  type Contact = {
    phone: string
    email: string
  }

  type PersonInfo = Person & Contact
  const p1: PersonInfo = {
    name: "ㅁㅁㅁ",
    age: 50,
    phone: "010",
    email: "@",
  }

  const p2: Person & Contact = p1

  let aaa: number | string | boolean = 1
  aaa = "asd"
  aaa = true
})()
