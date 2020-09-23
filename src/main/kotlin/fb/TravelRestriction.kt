package fb

import java.io.File

class TravelRestriction {
    val output: File = File("travel_restrictions_validation_output.txt")
    private var content: String = ""
    fun execute(input: File) {
        val lines = input.readLines()
        val numberOfExecution = lines.first().toInt()
        for (i in 0 until numberOfExecution) {
            content += "Case #${i+1}:\n"
            val size = lines[i * 3 + 1].toInt()
            val inbounds = lines[i * 3 + 2].toCharArray()
            val outbounds = lines[i * 3 + 3].toCharArray()
            availableFlight(size, inbounds, outbounds)
        }
        output.writeText(content)
    }

    private fun availableFlight(size: Int, inbounds: CharArray, outbounds: CharArray) {
        for (i in 0 until size) {
            var sb = ""
            for (j in i downTo 1) {
                if (outbounds[j] == 'Y' && inbounds[j - 1] == 'Y') {
                    sb += "Y"
                } else {
                    break
                }

            }
            sb = sb.padEnd(i, 'N')
            sb = sb.reversed()
            sb += "Y"
            for (j in i until size - 1) {
                if (outbounds[j] == 'Y' && inbounds[j + 1] == 'Y') {
                    sb += "Y"
                } else {
                    break
                }
            }
            sb = sb.padEnd(size, 'N')
            content += sb + "\n"
        }
    }
}

fun main() {
    val travelRestriction = TravelRestriction()
    travelRestriction.execute(File("C:\\Users\\CongCuong\\workspace\\algorithm\\src\\main\\kotlin\\fb\\travel_restrictions_validation_input.txt"))
}