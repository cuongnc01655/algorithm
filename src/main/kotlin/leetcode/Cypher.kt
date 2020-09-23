package leetcode

import leetcode.Cypher.reverseWords
import kotlin.test.assertEquals

/**
 * Your team is scrambling to decipher a recent message, worried it's a plot to break into a major European National Cake Vault. The message has been mostly deciphered, but all the words are backward! Your colleagues have handed off the last step to you.

Write a method reverseWords() that takes a message as an array of characters and reverses the order of the words in place.

Why an array of characters instead of a string?
The goal of this question is to practice manipulating strings in place. Since we're modifying the message, we need a mutable
type like an array, instead of Java's immutable strings.
For example:

char[] message = { 'c', 'a', 'k', 'e', ' ',
'p', 'o', 'u', 'n', 'd', ' ',
's', 't', 'e', 'a', 'l' };

reverseWords(message);

System.out.println(message);
// prints: "steal pound cake"

When writing your method, assume the message contains only letters and spaces, and all words are separated by one space.

Solution: reverse in place: reverse each word, then reverse whole string
 */
object Cypher {
    fun reverseWords(message: CharArray) {
        var lastIndex = 0
        for (i in message.indices) {
            if (message[i] == ' ') {
               reverse(message, lastIndex, i-1)
                lastIndex = i+1
            }
        }
        //reverse last word
        reverse(message, lastIndex, message.size - 1)
        //reverse back whole string
        reverse(message, 0, message.size - 1)
    }

    private fun reverse(message: CharArray, start: Int, end: Int) {
        var s = start
        var e = end
        var tmp = ' '
        while (s < e) {
            tmp = message[s]
            message[s] = message[e]
            message[e] = tmp
            s++
            e--
        }
    }

//    reverse using copy array :D
    fun reverseWords1(message: CharArray) {
        val copied = CharArray(message.size)
        var lastIndex = message.size - 1
        var copyIndex = 0
        for ( i in message.size - 1 downTo 0) {
            if (message[i] == ' ') {
                for (j in i+1 .. lastIndex){
                    copied[copyIndex] = message[j]
                    copyIndex++
                }
                copied[copyIndex] = ' '
                copyIndex++
                lastIndex = i - 1
            }
        }

        for (j in 0 .. lastIndex){
            copied[copyIndex] = message[j]
            copyIndex ++
        }

        for (i in copied.indices) {
            message[i] = copied[i]
        }
    }
}

fun main() {
    oneWordTest()
    twoWordsTest()
    threeWordsTest()
    multipleWordsDifferentLengthsTest()
    multipleWordsSameLengthTest()
    emptyStringTest()
}


fun oneWordTest() {
    val expected = "vault".toCharArray()
    val actual = "vault".toCharArray()
    reverseWords(actual)
    for (i in expected.indices){
        assertEquals(expected[i], actual[i])
    }
}


fun twoWordsTest() {
    val expected = "cake thief".toCharArray()
    val actual = "thief cake".toCharArray()
    reverseWords(actual)
    for (i in expected.indices){
        assertEquals(expected[i], actual[i])
    }
}


fun threeWordsTest() {
    val expected = "get another one".toCharArray()
    val actual = "one another get".toCharArray()
    reverseWords(actual)
    for (i in expected.indices){
        assertEquals(expected[i], actual[i])
    }
}


fun multipleWordsSameLengthTest() {
    val expected = "the cat ate the rat".toCharArray()
    val actual = "rat the ate cat the".toCharArray()
    reverseWords(actual)
    for (i in expected.indices){
        assertEquals(expected[i], actual[i])
    }
}


fun multipleWordsDifferentLengthsTest() {
    val expected = "chocolate bundt cake is yummy".toCharArray()
    val actual = "yummy is cake bundt chocolate".toCharArray()
    reverseWords(actual)
    for (i in expected.indices){
        assertEquals(expected[i], actual[i])
    }
}


fun emptyStringTest() {
    val expected = "".toCharArray()
    val actual = "".toCharArray()
    reverseWords(actual)
    for (i in expected.indices){
        assertEquals(expected[i], actual[i])
    }
}