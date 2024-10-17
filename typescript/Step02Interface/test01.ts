;(function () {
  // type 별칭으로 작성하던 object의 모양을 interface로 만들수도 있다
  type MyType = {
    num: number
    name: string
    isMan: boolean
  }

  // object의 모양을 정의하는 느낌으로 작성하면 된다
  interface Member {
    num: number
    name: string
    isMan: boolean
  }

  // interface도 type이다
  let m1: Member = {
    num: 1,
    name: "ㅁㅁㅁ",
    isMan: true,
  }

  interface Person {
    firstname: string
    lastname: string
    email?: string // ?를 붙이면 optional(있어도 되고 없어도 됨)
  }

  let p1: Person = {
    firstname: "ㅁㅁㅁ",
    lastname: "ㄴㄴㄴ",
    email: "@",
  }
  let p2: Person = {
    firstname: "aaa",
    lastname: "sss",
  }

  // readonly property도 설정할 수 있다
  interface Todo {
    readonly id: number
    content: string
  }

  const t1: Todo = {
    id: 1,
    content: "공부하기",
  }
  // readonly는 읽기 전용이기때문에 수정 불가
  // t1.id = 2
  t1.content = "잠자기"
})()
