import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().split(" ").filter { it.isNotEmpty() }
    println(t.size)
}
