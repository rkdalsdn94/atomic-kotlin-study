// CCC '00 S1 - Slot Machines
// URL: https://dmoj.ca/problem/ccc00j3

/**
 * [핵심 아이디어]
 *     1. 3개의 슬롯머신을 순환하며 플레이하는 시뮬레이션을 구현한다.
 *     2. 각 머신의 누적 플레이 횟수를 추적하여 보상 지급 시점을 정확히 계산한다.
 *     3. Martha의 quarter가 0이 될 때까지 총 플레이 횟수를 계산한다.
 *     4. 머신별 보상 조건: 1번(35번째마다 30), 2번(100번째마다 60), 3번(10번째마다 9)
 *
 * [풀이 과정]
 *     1. Martha의 초기 quarter 개수와 각 머신의 현재 플레이 횟수를 입력받는다.
 *     2. Martha가 파산할 때까지 다음을 반복한다:
 *        a. 현재 머신을 플레이하고 1 quarter를 차감한다.
 *        b. 해당 머신의 플레이 횟수를 1 증가시킨다.
 *        c. 보상 조건(35, 100, 10의 배수)을 만족하면 해당 quarter를 추가한다.
 *        d. 다음 머신으로 순환 이동한다 (1 → 2 → 3 → 1 ...).
 *        e. 총 플레이 횟수를 1 증가시킨다.
 *     3. Martha가 파산했을 때의 총 플레이 횟수를 출력한다.
 */

fun main() {
    val quarters = readln().toInt()
    val machine1Plays = readln().toInt()
    val machine2Plays = readln().toInt()
    val machine3Plays = readln().toInt()

    var currentQuarters = quarters
    var plays1 = machine1Plays
    var plays2 = machine2Plays
    var plays3 = machine3Plays
    var totalPlays = 0
    var currentMachine = 0

    // Martha가 파산할 때까지 시뮬레이션
    while (currentQuarters > 0) {
        currentQuarters-- // 플레이 비용 차감 (1 quarter)
        totalPlays++

        when (currentMachine) {
            0 -> { // 1번 머신: 35번째마다 30 quarters 지급
                plays1++
                if (plays1 % 35 == 0) {
                    currentQuarters += 30
                }
            }
            1 -> { // 2번 머신: 100번째마다 60 quarters 지급
                plays2++
                if (plays2 % 100 == 0) {
                    currentQuarters += 60
                }
            }
            2 -> { // 3번 머신: 10번째마다 9 quarters 지급
                plays3++
                if (plays3 % 10 == 0) {
                    currentQuarters += 9
                }
            }
        }

        // 다음 머신으로 순환 이동 (0 → 1 → 2 → 0 ...)
        currentMachine = (currentMachine + 1) % 3
    }

    println("Martha plays $totalPlays times before going broke.")
}
