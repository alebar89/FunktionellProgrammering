package AoC2021.Day1

import java.io.File

class Day1A {
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
            if (index < listOfNumbers.size - 1) {
                val firstValue = listOfNumbers[index]
                val secondValue = listOfNumbers[index + 1]

                if (firstValue < secondValue) {
                    countingMeasurements++
                }
            }
        }
        println(countingMeasurements)
    }
}

fun main() {
    val testing = Day1A()
    testing.readingFromTextFile()
}