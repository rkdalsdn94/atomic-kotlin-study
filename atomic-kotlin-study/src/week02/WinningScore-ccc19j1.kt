// CCC '19 J1 - Winning Score
// URL: https://dmoj.ca/problem/ccc19j1

/**
 * [핵심 아이디어]
 *     1. 각 팀의 3점슛, 2점슛, 1점슛 개수를 입력받아 총 점수를 계산한다.
 *     2. 두 팀의 점수를 비교하여 승부 결과를 판정한다.
 *     3. 점수가 높은 팀이 승리, 같으면 무승부로 처리한다.
 *
 * [풀이 과정]
 *     1. Apples 팀의 3점슛, 2점슛, 1점슛 개수를 각각 입력받는다.
 *     2. Bananas 팀의 3점슛, 2점슛, 1점슛 개수를 각각 입력받는다.
 *     3. 각 팀의 총 점수를 계산한다: (3점슛 × 3) + (2점슛 × 2) + (1점슛 × 1)
 *     4. 두 팀의 점수를 비교하여 결과를 출력한다:
 *        - Apples가 더 높으면 'A'
 *        - Bananas가 더 높으면 'B'
 *        - 같으면 'T' (Tie)
 */

package week02

fun main() {
    val applesThree = readln().toInt()
    val applesTwo = readln().toInt()
    val applesOne = readln().toInt()

    val bananasThree = readln().toInt()
    val bananasTwo = readln().toInt()
    val bananasOne = readln().toInt()

    val applesScore = (applesThree * 3) + (applesTwo * 2) + (applesOne * 1)
    val bananasScore = (bananasThree * 3) + (bananasTwo * 2) + (bananasOne * 1)

    when {
        applesScore > bananasScore -> println("A")
        bananasScore > applesScore -> println("B")
        else -> println("T")
    }
}
