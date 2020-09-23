package fb

import java.io.File
import kotlin.math.abs

class Alchemy {
    val output: File = File("alchemy_validation_output.txt")
    private var content: String = ""
    fun execute(input: File) {
        val lines = input.readLines()
        val numberOfExecution = lines.first().toInt()
        for (i in 0 until numberOfExecution) {
            content += "Case #${i+1}: "
            val stones = lines[i * 2 + 2].toCharArray()
            val auburnStones = stones.filter { it == 'A' }.count()
            val blackStones = stones.filter { it == 'B' }.count()
            content += if (abs(blackStones - auburnStones) == 1) {
                "Y"
            } else {
                "N"
            }
            content += "\n"
        }
        output.writeText(content)
    }
}

fun main() {
    val alchemy = Alchemy()
    alchemy.execute(File("C:\\Users\\CongCuong\\workspace\\algorithm\\src\\main\\kotlin\\fb\\alchemy_validation_input.txt"))
}