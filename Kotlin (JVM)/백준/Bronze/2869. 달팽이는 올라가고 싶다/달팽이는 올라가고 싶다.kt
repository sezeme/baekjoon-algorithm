import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b, v) = br.readLine().split(" ").map { it.toInt() }
    var countDays = (v - b) / (a - b).toDouble()
    val tmp = countDays % 10 * 10 % 10
    if (tmp != 0.0) countDays += 1
    println(countDays.toInt())
}

