package week02

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val r = br.readLine().toInt()
    val h = br.readLine().toInt()

    val result = (PI * r * r * h) / 3
    println(result)
}
