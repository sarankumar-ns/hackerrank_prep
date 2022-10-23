import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*



/*
 * Complete the 'flippingMatrix' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
 */

fun flippingMatrix(matrix: Array<Array<Int>>): Int {
    // Write your code here

    val n = matrix.size.div(2)
    val maxMatrixIndex = matrix.size - 1
    var total : Int = 0

    for (row in 0 until n) {
        for (column in 0 until n) {
            val possibleValues = mutableListOf<Int>()
            possibleValues.add(matrix[row][column])
            possibleValues.add(matrix[row][maxMatrixIndex - column])
            possibleValues.add(matrix[maxMatrixIndex - row][column])
            possibleValues.add(matrix[maxMatrixIndex - row][maxMatrixIndex - column])
            total += possibleValues.max()
        }
    }

    return total
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val n = readLine()!!.trim().toInt()

        val matrix = Array<Array<Int>>(2 * n, { Array<Int>(2 * n, { 0 }) })

        for (i in 0 until 2 * n) {
            matrix[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
        }

        val result = flippingMatrix(matrix)

        println(result)
    }
}
