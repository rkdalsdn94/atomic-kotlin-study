// CCC '18 J2 - Occupy parking
// https://dmoj.ca/problem/ccc18j2

/**
 * [핵심 아이디어]
 *     어제와 오늘의 주차 상태를 같은 인덱스끼리 직접 비교하여
 *     두 날 모두 차가 있었던 주차공간의 개수를 카운트
 *
 * [풀이 과정]
 *     1. 어제와 오늘의 주차 상태를 각각 별도의 문자열로 입력받음
 *     2. 0부터 n-1까지 각 주차공간을 순회하며 같은 위치를 비교
 *     3. yesterday[i]와 today[i]가 모두 'C'인 경우에만 카운터 증가
 *     4. 최종 카운트 결과를 출력
 */

package week02

fun main() {
    val input = System.`in`.bufferedReader()
    val out = System.out.bufferedWriter()

    val n = input.readLine().toInt()         // 주차공간 개수
    val yesterday = input.readLine()          // 어제 주차 상태
    val today = input.readLine()              // 오늘 주차 상태
    var res = 0                              // 결과 카운터

    // 각 주차공간을 순회하며 어제와 오늘 모두 차가 있었는지 확인
    for (i in 0 until n) {
        if (yesterday[i] == 'C' && today[i] == 'C') {
            res += 1
        }
    }

    out.write("$res")
    out.close()
}
