// COCI '06 Contest 5 #1 Trik
// https://dmoj.ca/problem/coci06c5p1

/**
 * [핵심 아이디어]
 *     공의 현재 위치를 나타내는 변수를 사용하여, 각 컵 교환 규칙에 따라 공의 위치를 갱신합니다.
 *     A, B, C 세 가지 스왑 유형에 맞춰 공의 현재 위치가 어디냐에 따라 새로운 위치를 결정합니다.
 *
 * [풀이 과정]
 *     1. 공의 초기 위치를 가장 왼쪽 컵 (1)으로 설정합니다.
 *     2. 입력받은 Borko의 움직임 문자열(예: "AB", "CBABCACCC")을 한 글자씩 순회합니다.
 *     3. 각 움직임 문자('A', 'B', 'C')에 따라 다음과 같이 공의 위치를 업데이트합니다.
 *         - 'A' : 컵 1과 컵 2를 바꿉니다. (ballPosition이 1이면 2로, 2이면 1로 변경)
 *         - 'B' : 컵 2와 컵 3을 바꿉니다. (ballPosition이 2이면 3으로, 3이면 2로 변경)
 *         - 'C' : 컵 1과 컵 3을 바꿉니다. (ballPosition이 1이면 3으로, 3이면 1로 변경)
 *     4. 모든 움직임을 처리한 후, 최종적으로 공이 위치한 컵의 인덱스를 출력합니다.
 */

package week02

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val moves = scanner.nextLine()

    var ballPosition = 1 // 1: 왼쪽, 2: 가운데, 3: 오른쪽

    for (move in moves) {
        when (move) {
            'A' -> {
                when (ballPosition) {
                    1 -> ballPosition = 2
                    2 -> ballPosition = 1
                }
            }
            'B' -> {
                when (ballPosition) {
                    2 -> ballPosition = 3
                    3 -> ballPosition = 2
                }
            }
            'C' -> {
                when (ballPosition) {
                    1 -> ballPosition = 3
                    3 -> ballPosition = 1
                }
            }
        }
    }

    println(ballPosition)
    scanner.close()
}
