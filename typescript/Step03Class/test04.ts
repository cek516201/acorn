;(function () {
  class Phone {
    call() {
      console.log("전화걸기")
    }
  }
  // extends 예약어를 사용해서 상속을 받을 수 있다
  class HandPhone extends Phone {
    mobileCall() {
      console.log("이동중에 전화걸기")
    }
    takePicture() {
      console.log("30만 화소의 사진 찍기")
    }
  }

  const p1 = new Phone()
  const p2 = new HandPhone()
  p1.call()
  p2.call()
  p2.mobileCall()
  p2.takePicture()

  class SmartPhone extends HandPhone {
    doInternet() {
      console.log("인터넷 하기")
    }
    takePicture() {
      super.takePicture() // 부모(HandPhone)의 takePicture
      console.log("50만 화소의 사진 찍기")
    }
  }

  const p3 = new SmartPhone()
  p3.doInternet()
  p3.takePicture()
})()
