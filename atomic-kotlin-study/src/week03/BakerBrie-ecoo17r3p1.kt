// ECOO '17 R3 P1 - Baker Brie
// https://dmoj.ca/problem/ecoo17r3p1

/**
 * [핵심 아이디어]
 * - 일별로 모든 프랜차이즈 판매량 합이 13의 배수인지 확인
 * - 각 프랜차이즈별로 전체 기간 총 판매량이 13의 배수인지 확인
 * - 13의 배수인 경우 해당 수를 13으로 나눈 몫을 결과에 누적
 *
 * [풀이 과정]
 * 1. 여러 테스트케이스를 EOF까지 처리
 * 2. 각 날짜별로 모든 프랜차이즈 판매량의 합계 계산
 * 3. 합계가 13의 배수이면 몫을 결과에 추가
 * 4. 각 프랜차이즈별로 전체 기간 판매량 총합 계산
 * 5. 총합이 13의 배수이면 몫을 결과에 추가
 * 6. 최종 결과 출력
 */

package week03

fun main() {
    while (true) {
        try {
            // n: 프랜차이즈 개수, m: 일수
            val input = readLine() ?: break
            val (n, m) = input.split(" ").map { it.toInt() }

            // 각 날짜별 프랜차이즈 판매량 데이터 입력
            val salesData = mutableListOf<List<Int>>()
            repeat(m) {
                val dailySales = readLine()!!.split(" ").map { it.toInt() }
                salesData.add(dailySales)
            }

            var result = 0

            // 일별 합계가 13의 배수인지 확인
            for (dailySales in salesData) {
                val dailyTotal = dailySales.sum()
                if (dailyTotal % 13 == 0) {
                    result += dailyTotal / 13
                }
            }

            // 각 프랜차이즈별 총 판매량이 13의 배수인지 확인
            for (franchiseIdx in 0 until n) {
                var franchiseTotal = 0

                // 해당 프랜차이즈의 모든 날짜 판매량 합계
                for (dayIdx in 0 until m) {
                    franchiseTotal += salesData[dayIdx][franchiseIdx]
                }

                // 13의 배수이면 baker's dozen 개수 추가
                if (franchiseTotal % 13 == 0) {
                    result += franchiseTotal / 13
                }
            }

            println(result)

        } catch (e: Exception) {
            break
        }
    }
}
