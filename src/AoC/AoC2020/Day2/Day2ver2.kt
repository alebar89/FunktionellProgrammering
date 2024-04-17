package AoC2020.Day2

import java.io.File

/*
REMAKING THE PROGRAM USING SOLUTIONS FOUND ON REDDIT

SOURCES:
https://www.reddit.com/r/adventofcode/comments/k52psu/comment/ged2db9/?utm_source=share&utm_medium=web3x&utm_name=web3xcss&utm_term=1&utm_content=share_button
 */

class Day2ver2 {
    fun readingFromTextFile() {
        val source = "src/AoC/AoC2020/Day2/MyFile"
        var validPasswords = 0
        val regex = """(\d+)-(\d+) (.): (\w+)""".toRegex()

        /* A-UPPGIFTEN
        File(source).forEachLine { line ->
            regex.matchEntire(line)
                ?.destructured
                ?.let { (min, max, char, password) ->
                    val count = password.count { it == char[0] }
                    if (count in min.toInt()..max.toInt()) {
                        validPasswords++
                    }
                }
        }
         */

        //B-UPPGIFTEN
        File(source).forEachLine { line ->
            regex.matchEntire(line)
                ?.destructured
                ?.let { (firstCharacterPosition, secondCharacterPosition, char, password) ->
                    val firstChar = password.getOrNull (firstCharacterPosition.toInt() - 1)
                    val secondChar = password.getOrNull (secondCharacterPosition.toInt() - 1)
                    if ((firstChar == char[0]) xor (secondChar == char[0])) {
                        validPasswords++
                    }
                }
        }

        println(validPasswords)
    }
}

fun main() {
    val testing = Day2ver2()
    testing.readingFromTextFile()
}