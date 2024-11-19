import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val arr: Array<Int> = Array(26) { -1 }
    val input = br.readLine()
    for (i in 0..<input.length) {
        if(arr[input[i] - 'a'] != -1) continue
        arr[input[i]-'a'] = i
    }
    println(arr.joinToString(" "))
}
