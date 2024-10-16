// enum type
;(function () {
  enum Weapon {
    Gun,
    Sword,
    Arrow,
  }

  attack(Weapon.Sword)

  function attack(w: Weapon) {
    if (w === Weapon.Gun) {
      console.log("총으로 공격")
    } else if (w === Weapon.Sword) {
      console.log("칼로 공격")
    } else if (w === Weapon.Arrow) {
      console.log("활로 공격")
    }
  }
})()
