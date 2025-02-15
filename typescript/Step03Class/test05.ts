;(function () {
  class Engine {}

  class Car {
    private engine: Engine

    constructor(engine: Engine) {
      this.engine = engine
    }

    drive() {
      console.log("달려요")
    }
  }

  class MyCar extends Car {
    constructor(engine: Engine) {
      super(engine) //부모 생성자에 값을 전달 하기
    }
    myDrive() {
      console.log("내가 알아서 달려요!")
    }
  }

  const c1 = new MyCar(new Engine())
  c1.drive()
  c1.myDrive()

  // 다형성
  const c2: Car = new MyCar(new Engine())
  const c3: Car = c2
  const c4: MyCar = c3 as MyCar // as로 캐스팅
})()
