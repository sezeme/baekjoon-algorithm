import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/*
시간복잡도 계산
20_000
sort하는데 nlogn
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val arr = mutableListOf<String>()

    repeat(n) {
        arr.add(br.readLine())
    }

    val sortedArr = arr.distinct().sortedWith(
        compareBy<String> { it.length }.thenBy { it }
    )

    sortedArr.forEach { bw.write(it + "\n") }
    bw.flush()
    bw.close()
    br.close()
}
