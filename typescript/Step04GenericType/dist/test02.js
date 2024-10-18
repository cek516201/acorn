"use strict";
;
(function () {
    class Orange {
    }
    class Apple {
    }
    class Banana {
    }
    class FruitBox {
        constructor(item) {
            this.item = item;
        }
        getItem() {
            return this.item;
        }
    }
    const box1 = new FruitBox(new Orange());
    const box2 = new FruitBox(new Apple());
    const box3 = new FruitBox(new Banana());
    const result1 = box1.getItem();
    const result2 = box2.getItem();
    const result3 = box3.getItem();
})();
