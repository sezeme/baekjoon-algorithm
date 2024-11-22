import java.io.BufferedReader
import java.io.InputStreamReader

const val R = 31
const val M = 1234567891L

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val alphabets = br.readLine()
        .split("")
        .filter { it.isNotEmpty() }
        .map { it[0] - 'a' + 1 }


    var sum = 0L
    alphabets.forEachIndexed { index, it ->
        var result = 1L
        repeat(index) {
            result *= R % M
        }
        sum += (result * it % M)
    }

    println(sum)
}

