import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val set = mutableSetOf<Int>()
    repeat(10){
        val input = br.readLine().toInt()
        val mod = input % 42
        set.add(mod)
    }

    println(set.size)
}
