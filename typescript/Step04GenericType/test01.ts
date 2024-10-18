;(function () {
  function getData<T>(item: T): T {
    return item
  }

  const getData2 = function <T>(item: T) {
    return item
  }

  const getData3 = <T>(item: T) => {
    return item
  }

  const result: number = getData<number>(999)
  const result2: string = getData<string>("ㅁㅁㅁ")
})()
