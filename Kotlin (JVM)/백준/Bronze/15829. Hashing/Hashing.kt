import java.io.BufferedReader
import java.io.InputStreamReader

const val M = 1234567891L

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val alphabets = br.readLine()
    var res = 0L
    var pow = 1L
    repeat(n) {
        res += (alphabets[it] - 'a' + 1) * pow % M
        pow = pow * 31 % M
    }

    println(res % M)
}

