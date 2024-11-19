import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    // 1 6(6 * 1) 12(6 * 2) ...
    var cnt = 1
    var sum = 1
    while (true) {
        if (sum >= n) break
        sum += 6 * cnt
        cnt++
    }
    println(cnt)
}
