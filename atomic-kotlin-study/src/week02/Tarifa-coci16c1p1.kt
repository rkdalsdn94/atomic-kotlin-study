// COCI '16 Contest 1 #1 Tarifa
// https://dmoj.ca/problem/coci16c1p1

/**
 * [핵심 아이디어]
 *     1. 매달 (기본 용량 - 사용량)의 차이만큼 용량이 누적됩니다.
 *     2. 각 달의 순증감량을 모두 합한 후, 마지막에 N+1번째 달의 기본 용량을
 *     3. 추가하면 최종 사용 가능한 용량을 구할 수 있습니다.
 *
 * [풀이 과정]
 *     1. 각 달마다 (기본 용량 X - 해당 달 사용량) 계산 누적
 *     2. 해당 달에 실제로 증가하거나 감소한 용량
 *     3. N개월간의 모든 순증감량을 합산
 *     4. 마지막으로 N + 1번째 달의 기본 용량 X를 추가하고, 출력
 */

package week02

fun main() {
    val input = System.`in`.bufferedReader()
    val out = System.out.bufferedWriter()

    val x = input.readLine().toInt() // 매달 기본 용량
    val n = input.readLine().toInt() // 요금제 사용 개월 수
    val nList = mutableListOf<Int>()
    for (i in 0 until n) {
        nList.add(input.readLine().toInt())
    }

    var result = 0 // 누적된 순증감량

    for (i in 0 until n) {
        result += x - nList[i]
    }

    result += x // N + 1번째 달의 기본 용량 추가
    out.write("$result")
    out.close()
}
