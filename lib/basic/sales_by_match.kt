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
 * Complete the 'sockMerchant' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY ar
 */

fun sockMerchant(n: Int, ar: Array<Int>): Int {
    // Write your code here

    val socksByColor = mutableListOf<Pairs>()

    for (i in ar) {
        val available = socksByColor.find { item -> item.color == i }

        if(available == null) {
            socksByColor.add(Pairs(i, 1))
        } else {
            socksByColor[socksByColor.indexOf(available)] = Pairs(available.color, available.items + 1)
        }
    }

    var totalPairs = 0

    socksByColor.forEach {
        if(it.items.rem(2) == 1) {
            totalPairs += it.items.minus(1).div(2)
        } else {
            totalPairs += it.items.div(2)
        }
    }

    return totalPairs

}

data class Pairs (
    var color: Int,
    var items: Int
)

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val ar = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}
