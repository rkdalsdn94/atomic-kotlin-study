// CCO '99 P2 - Common Words
// https://dmoj.ca/problem/cco99p2

/**
 * [핵심 아이디어]
 * k번째로 흔한 단어란 "자신보다 더 자주 나오는 서로 다른 빈도가 정확히 (k-1)개 있는 단어"이다.
 * 즉, 자신보다 큰 빈도값의 종류가 정확히 (k-1)개인 단어들을 찾는다.
 *
 * [풀이 과정]
 * 1. 각 단어의 빈도를 계산
 * 2. 각 단어에 대해 자신보다 큰 빈도값의 개수를 계산
 * 3. 그 개수가 정확히 (k-1)개인 단어들을 필터링
 * 4. 결과를 알파벳 순으로 정렬하여 출력
 */

package week03

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val datasetCount = reader.readLine().toInt()
    val outputs = mutableListOf<String>()

    repeat(datasetCount) {
        outputs.add(calculate(reader))
    }

    val result = outputs.joinToString("\n")
    writer.write(result)
    writer.flush()
    writer.close()
    reader.close()
}

/**
 * 숫자를 ordinal notation으로 변환 (1st, 2nd, 3rd, 4th, 5th, ...)
 */
fun ordinal(n: Int): String {
    return when {
        n % 100 in 11..13 -> "${n}th"  // 11th, 12th, 13th는 예외
        n % 10 == 1 -> "${n}st"
        n % 10 == 2 -> "${n}nd"
        n % 10 == 3 -> "${n}rd"
        else -> "${n}th"
    }
}

/**
 * 한 데이터셋을 처리하는 함수
 */
fun calculate(reader: BufferedReader): String {
    val line = reader.readLine().split(" ")
    val wordCount = line[0].toInt()
    val commonCount = line[1].toInt()

    // 단어 빈도 계산
    val wordMap = mutableMapOf<String, Int>()
    repeat(wordCount) {
        val word = reader.readLine()
        wordMap[word] = wordMap.getOrDefault(word, 0) + 1
    }

    // k번째로 흔한 단어들 찾기
    val targetWords = mutableListOf<String>()
    for ((entryKey, entryValue) in wordMap) {
        // 현재 단어의 빈도보다 큰 빈도값들의 개수를 센다
        val biggerCount = wordMap.values.count { freq -> freq > entryValue }
        if (biggerCount == commonCount - 1) {
            targetWords.add(entryKey)
        }
    }

    // 알파벳 순으로 정렬
    targetWords.sort()

    // 결과 문자열 생성
    val result = buildString {
        append("${ordinal(commonCount)} most common word(s):\n")
        targetWords.forEach { word ->
            append("$word\n")
        }
        append("\n")
    }

    return result
}
