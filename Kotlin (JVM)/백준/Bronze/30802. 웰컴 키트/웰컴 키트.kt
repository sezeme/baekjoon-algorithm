import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val array = br.readLine().split(" ").map { it.toInt() }
    val (t, p) = br.readLine().split(" ").map { it.toInt() }
    var numberOfT = 0
    for (i in array) {
        if (i % t != 0) numberOfT++
        numberOfT += i / t
    }
    println(numberOfT)
    println("${n / p} ${n % p}")
}
