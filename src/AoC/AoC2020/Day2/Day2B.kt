package AoC2020.Day2

import java.io.File

class Day2B {
    fun readingFromTextFile() {
        var source = "src/AoC/AoC2020/Day2/MyFile"
        var validPasswords = 0

        File(source).forEachLine { line ->
            val partsOfString = line.split(":")
            val firstPartOfString = partsOfString[0]

            val firstPartSplit = firstPartOfString.split(" ")
            val firstPartOfFirstString = firstPartSplit[0]
            val (firstNumberAsString, secondNumberAsString) = firstPartOfFirstString.split("-")
            val characterToLookFor = firstPartSplit[1][0]

            val password = partsOfString[1].trim()

            val firstCharacterPosition = firstNumberAsString.toInt() - 1
            val secondCharacterPosition = secondNumberAsString.toInt() - 1

            if ((password[firstCharacterPosition] == characterToLookFor && password[secondCharacterPosition] != characterToLookFor) ||
                (password[firstCharacterPosition] != characterToLookFor && password[secondCharacterPosition] == characterToLookFor)) {
                validPasswords++
            }
        }
        println(validPasswords)
    }
}

fun main() {
    val testing = Day2B()
    testing.readingFromTextFile()
}
