"use strict"
;(function () {
  class Engine {}
  class Car {
    constructor(engine) {
      this.engine = engine
    }
    drive() {
      console.log("달려요")
    }
  }
  class MyCar extends Car {
    constructor(engine) {
      super(engine) //부모 생성자에 값을 전달 하기
    }
    myDrive() {
      console.log("내가 알아서 달려요!")
    }
  }
  const c1 = new MyCar(new Engine())
  c1.drive()
  c1.myDrive()
})()
