import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var cnt: Int
    var sum: Int
    repeat(n) {
        sum = 0
        cnt = 0
        val input = br.readLine()
        for (i in 0 until input.length) {
            val char = input[i]
            if (char == 'O') {
                cnt++
                sum += cnt
            } else if (char == 'X') {
                cnt = 0
            }
        }
        println(sum)
    }

}
