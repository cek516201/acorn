fun main() {
    var a: String
    var b: String = "kim"
    // type이 맞지 않아서 null이 안들어간다
    // var c: String = null
    // null값을 허용하려면 data type 뒤에 suffix로 ?를 붙여야한다
    // string type과 string? type은 다르다
    var c: String? = null

    // c?.length의 의미는 "c가 null이 아닌 경우에만 length를 참조해라"
    // c가 null이면 null이 리턴된다
    println(b.length.toString() + " " + c?.length)
}