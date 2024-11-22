import java.io.BufferedReader
import java.io.InputStreamReader

const val M = 1234567891L

//무의미한 0이 앞에 올 수 없음
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var input = br.readLine()
    while (input != "0") {
        var isPelindrom = true
        for (i in input.indices) {
            if (i * 2 > input.length) break //5
            if (input[i] != input[input.length - i - 1]) {
                isPelindrom = false
                break
            }
        }
        if (isPelindrom) println("yes")
        else println("no")
        input = br.readLine()
    }
}


