// CCC '08 J2 - Do the Shuffle
// https://dmoj.ca/problem/ccc08j2

/**
 * 시뮬레이션, 리스트 조작 문제
 *
 * [핵심 아이디어]
 *     1. 재생목록을 가변 리스트로 관리하여 동적인 곡 순서 변경을 처리한다.
 *     2. 각 버튼의 동작을 정확히 구현하되, n번 반복 수행에 주의한다.
 *     3. 문제에서 요구하는 정확한 출력 형식(공백 구분)을 맞춘다.
 *     4. 종료 조건(버튼 4, 횟수 1)을 명확히 처리한다.
 *
 * [풀이 과정]
 *     1. 초기 재생목록 ["A", "B", "C", "D", "E"]를 리스트로 초기화한다.
 *     2. 무한 루프에서 버튼 번호(b)와 누르는 횟수(n)를 입력받는다.
 *     3. 종료 조건 확인: b=4, n=1이면 현재 재생목록을 공백으로 구분하여 출력 후 종료한다.
 *     4. 각 버튼별로 n번 반복하여 연산 수행:
 *        - 버튼 1: 첫 번째 요소를 맨 뒤로 이동 (회전)
 *        - 버튼 2: 마지막 요소를 맨 앞으로 이동 (역회전)
 *        - 버튼 3: 첫 번째와 두 번째 요소의 위치를 교환
 *     5. 리스트 조작 시 불변성을 유지하며 새로운 리스트를 생성한다.
 */

package week02

fun main() {
    var cmpPlayList: List<String> = listOf("A", "B", "C", "D", "E")

    while (true) {
        val b = readLine()!!.toInt()  // 버튼 번호
        val n = readLine()!!.toInt()  // 누르는 횟수

        // 종료 조건 확인
        if (b == 4 && n == 1) {
            println(cmpPlayList.joinToString(" "))  // 공백으로 구분하여 출력
            break
        }

        if (b == 1) {
            for (i in 0 until n) {
                // 현재 재생목록의 첫 번째 곡을 맨 뒤로 이동
                val firstSong = cmpPlayList.first()
                cmpPlayList = cmpPlayList.drop(1) + firstSong
            }
        } else if (b == 2) {
            for (i in 0 until n) {
                val lastSong = cmpPlayList.last()
                cmpPlayList = listOf(lastSong) + cmpPlayList.dropLast(1)  // 맨 앞에 붙임
            }
        } else if (b == 3) {
            for (i in 0 until n) {
                // 재생 목록의 처음 두 곡을 바꿈
                val firstSong = cmpPlayList.first()
                val secondSong = cmpPlayList[1]
                cmpPlayList = listOf(secondSong, firstSong) + cmpPlayList.drop(2)
            }
        }
    }
}
