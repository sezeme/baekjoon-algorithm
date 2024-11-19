import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }
    val sumOfArgument = mutableListOf<Int>()
    // 3장의 카드 고르기
    for (i in 0..<n - 2) {
        for (j in i + 1..<n - 1) {
            for (k in j + 1..<n) {
                sumOfArgument.add(arr[i] + arr[j] + arr[k])
            }
        }
    }
    val sortedSum = sumOfArgument.sorted().toList()

    for (i in sortedSum.indices) {
        if(sortedSum[i] > m){
            println(sortedSum[i-1])
            return
        }
    }
    println(sortedSum[sortedSum.size-1])
}
