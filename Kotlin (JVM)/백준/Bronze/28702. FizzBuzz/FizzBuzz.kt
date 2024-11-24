import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/*

 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var resultInt = 0

    for (i in 0..2) {
        val input = br.readLine()
        if (input != "Fizz" && input != "Buzz" && input != "FizzBuzz") {
            when (i) {
                0 -> {
                    resultInt = input.toInt() + 3
                }
                1 -> {
                    resultInt = input.toInt() + 2
                }
                2 -> {
                    resultInt = input.toInt() + 1
                }
            }
            break
        }
    }

    if (resultInt % 3 == 0) bw.write("Fizz")
    if (resultInt % 5 == 0) bw.write("Buzz")
    if(resultInt%3 != 0 && resultInt%5 != 0) bw.write(resultInt.toString())

    bw.flush()
    bw.close()
    br.close()
}
