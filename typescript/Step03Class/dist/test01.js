"use strict";
;
(function () {
    class Car {
        // 생성자
        constructor(name) {
            this.name = name;
        }
        // 메소드
        drive() {
            console.log(this.name + "이 달려요");
        }
    }
    const c1 = new Car("소나타");
    const c2 = new Car("아반떼");
    c1.drive();
    c2.drive();
    const f1 = c1.drive;
    // f1()
    // this가 c2 객체를 가리킬 수 있도록 binding을 하면 정상작동한다
    const f2 = c2.drive.bind(c2);
    f2();
})();
