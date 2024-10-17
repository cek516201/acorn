"use strict";
// enum type
;
(function () {
    let Weapon;
    (function (Weapon) {
        Weapon[Weapon["Gun"] = 0] = "Gun";
        Weapon[Weapon["Sword"] = 1] = "Sword";
        Weapon[Weapon["Arrow"] = 2] = "Arrow";
    })(Weapon || (Weapon = {}));
    attack(Weapon.Sword);
    function attack(w) {
        if (w === Weapon.Gun) {
            console.log("총으로 공격");
        }
        else if (w === Weapon.Sword) {
            console.log("칼로 공격");
        }
        else if (w === Weapon.Arrow) {
            console.log("활로 공격");
        }
    }
})();
