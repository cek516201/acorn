package com.example.hellokotlin

fun main() {
    // 타입 추론이 가능한 경우 에는 type 생략 가능
    var num = 10
    var num2 = 10.1
    var isRun = true
    var myName = "ㅁㅁㅁ"

    var num3: Int
    num3 = 10
    var yourName = "ㄴㄴㄴ"
    yourName = "ㅇㅇㅇ"

    // 상수를 미리 선언하고 값을 나중에 대입할수도 있다
    val PI: Float
    PI = 3.14159f

    println(myName)
}