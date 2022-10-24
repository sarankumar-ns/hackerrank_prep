import kotlin.io.*
import kotlin.text.*

/*
 * Complete the 'caesarCipher' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. STRING s
 *  2. INTEGER k
 */

fun caesarCipher(s: String, k: Int): String {
    // Write your code here
    var k = k % 26
    val alphabetSmall = "abcdefghijklmnopqrstuvwxyz"
    val alphabetCaps = alphabetSmall.toUpperCase()

    var encryptedText = ""
    for (letter in s) {
        var foundInSmall = false
        for(i in alphabetSmall.indices) {
            if(alphabetSmall[i] == letter) {
                foundInSmall = true
                encryptedText +=  if(i+k > 25) {
                    alphabetSmall[i+k - 26]
                } else {
                    alphabetSmall[i+k]
                }
            }
        }
        if(!foundInSmall) {
            var foundInCaps = false
            for(i in alphabetCaps.indices) {
                if(alphabetCaps[i] == letter) {
                    foundInCaps = true
                    encryptedText +=  if(i+k > 25) {
                        alphabetCaps[i+k - 26]
                    } else {
                        alphabetCaps[i+k]
                    }
                }
            }
            if(!foundInCaps) {
                encryptedText += letter
            }
        }
    }

    return encryptedText;

}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val s = readLine()!!

    val k = readLine()!!.trim().toInt()

    val result = caesarCipher(s, k)

    println(result)
}
