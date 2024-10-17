// 접근 지정자
// public : 전체 공개(기본값)
// protected : 상속관계에서 공개
// private : 비공개
;(function () {
  class Person {
    private firstname: string
    private lastname: string

    constructor(firstname: string, lastname: string) {
      this.firstname = firstname
      this.lastname = lastname
    }

    showInfo() {
      console.log(`이름 : ${this.firstname} ${this.lastname}`)
    }
  }

  const p1 = new Person("aaa", "sss")
  p1.showInfo()
  // 필드에 접근 불가
  // p1.firstname = "xxx"
  // p1.lastname = "xxx"
})()
