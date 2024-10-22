import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numList = mutableListOf<Int>()
    for (i in 0..<9) {
        numList.add(br.readLine().toInt())
    }

    var max = 0
    for (i in 0..<9) {
        if (numList[max] < numList[i])
            max = i
    }

    println(numList[max])
    println(max + 1)
}