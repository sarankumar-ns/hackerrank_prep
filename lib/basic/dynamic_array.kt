import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'dynamicArray' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. 2D_INTEGER_ARRAY queries
 */

fun dynamicArray(n: Int, queries: Array<Array<Int>>): Array<Int> {
    // Write your code here
    var lastAnswer = 0
    val arr: Array<MutableList<Int>> = Array<MutableList<Int>>(n) { MutableList(0) { 0 } }
    val answers : MutableList<Int> = mutableListOf()

    for(query in queries.indices) {

        val idx = (queries[query][1].xor(lastAnswer)).rem(n)
        if(queries[query][0] == 1) {
            arr[idx].add(queries[query][2])
        } else {
            lastAnswer = arr[idx][queries[query][2].rem(arr[idx].size)]
            answers.add(lastAnswer)
        }
    }

    return answers.toTypedArray();
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val q = first_multiple_input[1].toInt()

    val queries = Array<Array<Int>>(q, { Array<Int>(3, { 0 }) })

    for (i in 0 until q) {
        queries[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = dynamicArray(n, queries)

    println(result.joinToString("\n"))
}
