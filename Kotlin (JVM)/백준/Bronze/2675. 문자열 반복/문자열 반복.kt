import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val (r, s) = br.readLine().split(" ")
        val repeatCont = r.toInt()
        val result = s.map { it.toString().repeat(repeatCont) }.joinToString("")
        println(result)
    }
}
