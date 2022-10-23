package lib.basic

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
 * Complete the 'twoArrays' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. INTEGER k
 *  2. INTEGER_ARRAY A
 *  3. INTEGER_ARRAY B
 */

fun twoArrays(k: Int, A: Array<Int>, B: Array<Int>): String {

    val n : Int = A.size - 1
    var isSatisfies = true
    A.sort()
    B.sort()


    for (i in 0..n) {
        if (A[i] + B[n - i] < k) {
            isSatisfies = false
        }
    }

    return if (isSatisfies) "YES" else "NO";
}



fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val n = first_multiple_input[0].toInt()

        val k = first_multiple_input[1].toInt()

        val A = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

        val B = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

        val result = twoArrays(k, A, B)

        println(result)
    }
}
