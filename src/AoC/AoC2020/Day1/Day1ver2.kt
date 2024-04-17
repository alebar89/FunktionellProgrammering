package AoC2020.Day1

import java.io.File
import java.io.InputStream

/*
REMAKING THE PROGRAM USING SOLUTIONS FOUND ON REDDIT

SOURCES:
https://www.reddit.com/r/adventofcode/comments/k4e4lm/comment/ge9d0ld/?utm_source=share&utm_medium=web3x&utm_name=web3xcss&utm_term=1&utm_content=share_button
 */

class Day1ver2 {
    val source = "src/AoC/AoC2020/Day1/MyFile"

    fun readingFromTextFile() {
        val targetValue = 2020
        val listOfNumbers = mutableListOf<Int>()
        val inputStream: InputStream = File (source).inputStream()

        //Källor
        //Inläsning med lambda: https://www.geeksforgeeks.org/read-from-files-using-inputreader-in-kotlin/
        //Konvertera String till int i Kotlin: https://developermemos.com/posts/converting-string-to-int-in-kotlin
        inputStream.reader().useLines { lines ->
            lines.forEach {
                val int: Int = Integer.parseInt(it)
                listOfNumbers.add(int)
            }
        }

        //A-UPPGIFTEN

        val result = listOfNumbers.flatMap { number1 ->
            listOfNumbers.mapNotNull { number2 ->
                if (number1 + number2 == targetValue)
                    number1 * number2 else null
            }
        }.firstOrNull()

        //B-UPPGIFTEN
        /*
        val result = listOfNumbers.flatMap { number1 ->
            listOfNumbers.flatMap { number2 ->
                listOfNumbers.mapNotNull { number3 ->
                    if (number1 + number2 + number3 == targetValue)
                        number1 * number2 * number3 else null
                }
            }
        }.firstOrNull()
         */

        println(result)

        /*
        outer@ for (number1 in listOfNumbers) {
            for (number2 in listOfNumbers) {
                val sum = number1 + number2
                if (sum == targetValue) {
                    println(number1 * number2)
                    break@outer
                }
            }
        }
         */
    }
}

fun main() {
    val proObj = Day1ver2()
    proObj.readingFromTextFile()
}
