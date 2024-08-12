fun main() {
    val myName = "ㅁㅁㅁ"
    val yourName = "ㄴㄴㄴ"
    val ourName = "ㅇㅇㅇ"

    val result = "내 이름은 " + myName + " 입니다"
    val result2 = "너의 이름은 ${yourName} 입니다"
    // 따로 연산할게 없다면 {}는 생략 가능
    val result3 = "우리의 이름은 $ourName 입니다"

    val num1 = 10
    val num2 = 20
    val result4 = "$num1 더하기 $num2 는 ${num1 + num2} 입니다"

    // 여러줄의 문자열
    val html="""
        <div>
            <p>ㄹㄹㄹ</p>
        </div>
    """
    val html2="""
        <div>
            <p>ㅎㅎㅎ</p>
        </div>
    """.trimIndent()
    println(html)
    println(html2)
}