;(function () {
  interface Member<T> {
    id: T
    name: string
    email: string
  }

  const m1: Member<number> = {
    id: 1,
    name: "ㅁㅁㅁ",
    email: "a@a",
  }

  const m2: Member<string> = {
    id: "aaa",
    name: "ㄴㄴㄴ",
    email: "s@s",
  }
})()
