package week01

// 1. 다음 코드의 출력 결과는?
fun q01() {
    val a = 5
    val b = 2.5
    println(a + b)
}

// 2. 다음 코드의 결과는?
fun q02() {
    val s = "Kotlin"
    println("Hello $s!")
}

// 3. 아래 코드에서 사용된 타입은 무엇인가요?
fun q03() {
    val isDone = false
    println(isDone::class)
}

// 4. Char 타입으로 한 글자 'A'를 변수로 선언하세요.
fun q04() {
    val a = 'A'
    println("$a, " + a::class)
}

// 5. val x = 1.23 은 어떤 타입으로 추론되나요?
fun q05() {
    val x = 1.23
    println(x::class)
}

// 6. Int의 최대값을 저장하는 상수는 무엇인가요?
fun q06() {
    println(Int.MAX_VALUE)
}

// 7. 삼중 큰따옴표를 사용하면 어떤 장점이 있나요?
fun q07() {
    val a = """
abc
cde
123
"""
    print(a)
}

// 8. 다음 코드에서 오류 없이 출력될 수 있도록 수정하세요
fun q08() {
    val x = 1
    println("Value is: ${x + 1}")
}

// 9. 점수가 90점 이상이면 A, 80점 이상이면 B, 아니면 C로 출력하는 if 식을 작성하세요
fun q09() {
    val score = 90
    println(if (score >= 90) "A" else if (score >= 80) "B" else "C")
}

// 10. 아래 코드를 for 문으로 바꾸세요
fun q10() {
    for (i in 1..3) {
        print("$i ")
    }
    println()
}

// 11. 다음 while 반복문이 몇 번 반복되는지 예측하세요
fun q11() {
    var i = 0
    while (i < 4) {
        print("$i ")
        i++
    }
    println()
}

// 12. 1부터 10까지 짝수만 출력하는 코드를 작성하세요
fun q12() {
    for (i in 2..10 step 2) {
        print("$i ")
    }
    println()
}

// 13. val s = "banana"에서 "a"가 몇 번 등장하는지 세는 코드를 작성하세요
fun q13() {
    val text = "banana"
    val count = text.count { it == 'a' }
    println(count)
}

// 14. for 루프를 사용해 1 4 9 16 25를 출력하세요
fun q14() {
    for (i in 1..5) {
        print("${i * i} ")
    }
    println()
}

// 15. 다음 코드의 결과를 예측하세요
fun q15() {
    val n = 7
    val result = if (n % 2 == 0) "even" else "odd"
    println(result)
}

// 16. 1부터 10까지 더한 합을 구하세요
fun q16() {
    print((1..10).sum())
    println()
}

// 17. 10에서 1까지 거꾸로 출력하는 for문을 작성하세요
fun q17() {
    for (i in 10 downTo 1) {
        print("$i ")
    }
    println()
}

fun main() {
    println("=== Kotlin 1주차 연습문제 실행 결과 ===\n")

    print("1. "); q01()  // 7.5
    print("2. "); q02()  // Hello Kotlin!
    print("3. "); q03()  // class kotlin.Boolean
    print("4. "); q04()  // A, class kotlin.Char
    print("5. "); q05()  // class kotlin.Double
    print("6. "); q06()  // 2147483647
    print("7."); q07()  // 여러 줄 문자열
    print("8. "); q08()  // Value is: 2
    print("9. "); q09()  // A
    print("10. "); q10() // 1, 2, 3
    print("11. "); q11() // 0, 1, 2, 3
    print("12. "); q12() // 2, 4, 6, 8, 10
    print("13. "); q13()  // 3
    print("14. "); q14()  // 1 4 9 16 25
    print("15. "); q15()  // odd
    print("16. "); q16()  // 55
    print("17. "); q17() // 10, 9, 8, ..., 1
}
