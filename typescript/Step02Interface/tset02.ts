;(function () {
  interface Area {
    (width: number, height: number): number
  }

  const util: Area = function (w: number, h: number) {
    return w * h
  }

  console.log(util(100, 200))
})()
