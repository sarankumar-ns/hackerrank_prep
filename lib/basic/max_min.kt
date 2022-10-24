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
 * Complete the 'maxMin' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER k
 *  2. INTEGER_ARRAY arr
 */

fun maxMin(k: Int, arr: Array<Int>): Int {
    // Write your code here

    arr.sort()

    var unfairValue = Int.MAX_VALUE

    for (i in 0..arr.size - k) {
        val difference = arr[k + i - 1].minus(arr[i])

        if (difference < unfairValue) {
            unfairValue = difference
        }
    }


    return unfairValue
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val k = readLine()!!.trim().toInt()

    val arr = Array<Int>(n) { 0 }
    for (i in 0 until n) {
        val arrItem = readLine()!!.trim().toInt()
        arr[i] = arrItem
    }

    val result = maxMin(k, arr)

    println(result)
}