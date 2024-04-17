package AoC2021.Day1

import java.io.File

/*
REMAKING THE PROGRAM USING SOLUTIONS FOUND ON REDDIT

SOURCES:
OM WINDOW-FUNKTIONEN I KOTLIN
https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/windowed.html
https://www.baeldung.com/kotlin/collections-api
FRÅN REDDIT:
https://www.reddit.com/r/adventofcode/comments/r66vow/comment/hms6ztr/?utm_source=share&utm_medium=web3x&utm_name=web3xcss&utm_term=1&utm_content=share_button
https://www.reddit.com/r/adventofcode/comments/r66vow/comment/hmrhogs/?utm_source=share&utm_medium=web3x&utm_name=web3xcss&utm_term=1&utm_content=share_button
https://www.reddit.com/r/adventofcode/comments/r66vow/comment/hmrp9h5/?utm_source=share&utm_medium=web3x&utm_name=web3xcss&utm_term=1&utm_content=share_button
https://www.reddit.com/r/adventofcode/comments/r66vow/comment/hmtast6/?utm_source=share&utm_medium=web3x&utm_name=web3xcss&utm_term=1&utm_content=share_button
 */

class Day1ver2 {
    fun readingFromTextFile() {
        val source = "src/AoC/AoC2021/Day1/MyFile"
        val listOfNumbers = mutableListOf<Int>()

        File(source).forEachLine {
            val lineValueToInt = it.toIntOrNull()
            if (lineValueToInt != null) {
                listOfNumbers.add(lineValueToInt)
            }
        }

        //A-UPPGIFTEN
        /*
        var countingMeasurements = 0
        val windows = listOfNumbers.windowed(size = 2, step = 1)
        windows.forEach { window ->
            val firstValue = window[0]
            val secondValue = window[1]

            if (secondValue > firstValue) {
                countingMeasurements++
            }
        }
         */

        //B-UPPGIFTEN
        var countingMeasurements = 0
        var index = 0;
        val windows = listOfNumbers.windowed(size = 3, step = 1)
        windows.forEach { window ->
            if (index < windows.size - 1) {
                val sumOfFirstElements = windows[index].sum()
                val sumOfSecondElements = windows[index + 1].sum()

                index++

                if (sumOfSecondElements > sumOfFirstElements) {
                    countingMeasurements++
                }
            }
        }

        println(countingMeasurements)
    }
}

fun main() {
    val testing = Day1ver2()
    testing.readingFromTextFile()
}