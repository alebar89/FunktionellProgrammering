package AoC2020.Day1

import java.io.File

class Day1B {
    fun readingFromTextFile() {
        val source = "src/AoC/AoC2020/Day1/MyFile"
        val targetValue = 2020
        val listOfNumbers = mutableListOf<Int>()

        File(source).forEachLine {
            val lineValueToInt = it.toIntOrNull()
            if (lineValueToInt != null) {
                listOfNumbers.add(lineValueToInt)
            }
        }

        outer@ for (number1 in listOfNumbers) {
            for (number2 in listOfNumbers) {
                for (number3 in listOfNumbers) {
                    val sum = number1 + number2 + number3
                    if (sum == targetValue) {
                        println(number1 * number2 * number3)
                        break@outer
                    }
                }
            }
        }
    }
}

fun main() {
    val testing = Day1B()
    testing.readingFromTextFile()
}
