import java.io.BufferedReader
import java.io.InputStreamReader

const val M = 1234567891L

//무의미한 0이 앞에 올 수 없음
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toDouble() }.sorted()
    var sum = 0.0
    for (i in 0..<n) {
        sum += arr[i]/arr[arr.lastIndex] * 100
    }
    println(sum/n)
}

