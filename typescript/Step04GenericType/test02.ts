;(function () {
  class Orange {}
  class Apple {}
  class Banana {}

  class FruitBox<T> {
    item: T

    constructor(item: T) {
      this.item = item
    }
    getItem(): T {
      return this.item
    }
  }

  const box1: FruitBox<Orange> = new FruitBox<Orange>(new Orange())
  const box2: FruitBox<Apple> = new FruitBox<Apple>(new Apple())
  const box3: FruitBox<Banana> = new FruitBox<Banana>(new Banana())

  const result1: Orange = box1.getItem()
  const result2: Apple = box2.getItem()
  const result3: Banana = box3.getItem()
})()
