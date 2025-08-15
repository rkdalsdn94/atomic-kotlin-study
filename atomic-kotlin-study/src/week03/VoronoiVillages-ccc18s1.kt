// CCC '18 S1 - Voronoi Villages
// https://dmoj.ca/problem/ccc18s1

/**
 * [핵심 아이디어]
 * 1. 직선 도로 위의 각 마을은 자신에게 가장 가까운 점들로 이루어진 neighbourhood를 가진다
 * 2. 인접한 두 마을 사이의 중점이 각 마을 neighbourhood의 경계가 된다
 * 3. 가장 왼쪽과 오른쪽 마을의 neighbourhood는 무한대이므로 제외한다
 * 4. 나머지 마을들의 neighbourhood 크기 중 최솟값을 구한다
 *
 * [풀이 과정]
 * 1. 마을들의 위치를 정렬한다
 * 2. 각 중간 마을(첫 번째와 마지막 제외)에 대해:
 *    - 왼쪽 경계: 현재 마을과 왼쪽 마을의 중점
 *    - 오른쪽 경계: 현재 마을과 오른쪽 마을의 중점
 *    - neighbourhood 크기: 오른쪽 경계 - 왼쪽 경계
 * 3. 모든 neighbourhood 크기 중 최솟값을 반환한다
 */

package week03

import kotlin.math.min

fun main() {
    val input = System.`in`.bufferedReader()
    val out = System.out.bufferedWriter()

    val villages = mutableListOf<Int>()
    val n = input.readLine().toInt()

    repeat(n) {
        val num = input.readLine().toInt()
        villages.add(num)
    }
    villages.sort()

    var result = Double.MAX_VALUE
    for (i in 1 until n - 1) {
        val left = (villages[i - 1] + villages[i]) / 2.0
        val right = (villages[i] + villages[i + 1]) / 2.0
        val neighborhoodSize = right - left

        result = min(result, neighborhoodSize)
    }

    out.write("%.1f".format(result))
    out.flush()
}
