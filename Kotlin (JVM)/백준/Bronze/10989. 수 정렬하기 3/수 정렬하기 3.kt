import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()

    // 배열 초기화
    val list = IntArray(10001)

    // 나타난 숫자 표시
    for (i in 0 until n) {
        list[br.readLine().toInt()]++
    }

    for (i in 1..10000) {
        bw.write("$i\n".repeat(list[i]))
    }

    bw.flush()
    bw.close()
    br.close()
}