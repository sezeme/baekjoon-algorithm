import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    val c = br.readLine().toInt()
    val multiple = (a * b * c).toString()
    val counts = IntArray(10)

    for (ch in multiple) {
        counts[ch - '0']++
    }

    for(i in 0..9) {
        println(counts[i])
    }
}
