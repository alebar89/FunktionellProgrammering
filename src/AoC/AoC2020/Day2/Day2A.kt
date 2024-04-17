package AoC2020.Day2

import java.io.File

class Day2A {
    fun readingFromTextFile() {
        var source = "src/AoC/AoC2020/Day2/MyFile"
        var validPasswords = 0

        File(source).forEachLine { line ->
            val partsOfString = line.split(":")
            val firstPartOfString = partsOfString[0]

            val firstPartSplit = firstPartOfString.split(" ")
            val firstPartOfFirstString = firstPartSplit[0]
            val (firstNumberAsString, secondNumberAsString) = firstPartOfFirstString.split("-")
            val characterAsString = firstPartSplit[1].single()

            val thePassword = partsOfString[1].trim()

            val minNumber = firstNumberAsString.toInt()
            val maxNumber = secondNumberAsString.toInt()
            val theCharacterToLookFor = characterAsString

            var numberOfOccurrence = 0

            for (char in thePassword) {
                if (char == theCharacterToLookFor) {
                    numberOfOccurrence++
                }
            }

            if (numberOfOccurrence in minNumber..maxNumber) {
                validPasswords++
            }
        }
        println(validPasswords)
    }
}

fun main() {
    val testing = Day2A()
    testing.readingFromTextFile()
}