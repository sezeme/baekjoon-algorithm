import java.io.BufferedReader
import java.io.InputStreamReader

/*

 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    var nPact = 1 // 1 * 2 * 3 * 4 * 5
    var nSubKPact = 1 // 1* 2* 3
    var kPact = 1 // 1* 2

    for (i in 1..n) {
        if (i <= n) nPact *= i
        if (i <= k) kPact *= i
        if (i <= (n - k)) nSubKPact *= i
    }

    println(nPact / (nSubKPact * kPact))

    br.close()
}
