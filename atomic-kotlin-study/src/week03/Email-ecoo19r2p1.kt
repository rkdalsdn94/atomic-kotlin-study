// ECOO '19 R2 P1 - Email
// https://dmoj.ca/problem/ecoo19r2p1

/**
 * [핵심 아이디어]
 * 1. 이메일 주소를 @ 기준으로 user part와 domain part로 분리
 * 2. user part에서 점(.) 제거, + 이후 문자열 제거
 * 3. 전체 이메일을 소문자로 변환하여 정규화
 * 4. Set 자료구조를 사용해 중복된 이메일 자동 제거
 *
 * [풀이 과정]
 * 1. 각 이메일을 @ 기준으로 분리하여 user와 domain 추출
 * 2. user 부분에서 점(.) 모두 제거
 * 3. user 부분에서 + 이후 문자열 제거 (+ 포함)
 * 4. user@domain 형태로 재조합 후 소문자로 변환
 * 5. Set에 추가하여 중복 자동 제거
 * 6. Set의 크기가 유니크한 이메일 개수
 */

package week03

fun main() {
    val input = System.`in`.bufferedReader()
    val out = System.out.bufferedWriter()

    while (true) {
        try {
            val n = input.readLine().toInt()
            val uniqueEmails = mutableSetOf<String>()

            repeat(n) {
                val email = input.readLine()
                val (user, domain) = email.split("@", limit = 2)

                val normalizedUser = user
                    .replace(".", "") // . 제거
                    .substringBefore("+") // + 이후 문자열 제거

                val reEmail = "$normalizedUser@$domain".lowercase();
                uniqueEmails.add(reEmail)
            }

            println(uniqueEmails.size)
        } catch (e: Exception) {
            break
        }
    }

    out.flush()
}
