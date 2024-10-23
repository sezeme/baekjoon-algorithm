import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val group = br.readLine()
            ?.split(" ")
            ?.map { it.toInt() }
        // h, w, n
        val x: Int? = group?.let {
            if (it[2] % it[0] == 0)
                it[2] / it[0]
            else
                (it[2] / it[0]) + 1
        }
        val y: Int? = group?.let {
            if (it[2] % it[0] == 0)
                it[0]
            else
                it[2] % it[0]
        }

        val result: String = y.toString() + x?.let {
            if (it < 10)
                "0$it"
            else it.toString()
        }
        println(result)
    }
}
