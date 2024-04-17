package AoC2021.Day1

import java.io.File

class Day1B {
    fun readingFromTextFile() {
        val source = "src/AoC/AoC2021/Day1/MyFile"
        val listOfNumbers = mutableListOf<Int>()

        File(source).forEachLine {
            val lineValueToInt = it.toIntOrNull()
            if (lineValueToInt != null) {
                listOfNumbers.add(lineValueToInt)
                //println(lineValueToInt)
            }
        }

        var countingMeasurements = 0
        listOfNumbers.forEachIndexed { index, value ->
            if (index < listOfNumbers.size - 3) {
                val firstValue = listOfNumbers[index]
                val secondValue = listOfNumbers[index + 1]
                val thirdValue = listOfNumbers[index + 2]
                val fourthValue = listOfNumbers[index + 3]

                val currentWindow = firstValue + secondValue + thirdValue
                val nextWindow = secondValue + thirdValue + fourthValue

                if (currentWindow < nextWindow) {
                    countingMeasurements++
                }
            }
        }
        println(countingMeasurements)
    }
}

fun main() {
    val testing = Day1B()
    testing.readingFromTextFile()
}