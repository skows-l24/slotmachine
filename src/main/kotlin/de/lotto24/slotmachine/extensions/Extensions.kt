package de.lotto24.slotmachine.extensions

/**
 * Extension functions for List Interface to pick randum quantity
 *
 * @author skows (initial creation).
 */

private val gen = java.util.Random()

fun <T> List<T>.pickRandom(quantity: Int): List<T> {
    return this.shuffle().take(quantity)
}

fun <T> List<T>.shuffle(): List<T> {
    val a = ArrayList(this)
    var n = a.size
    while (n > 1) {
        val k = gen.nextInt(n--)
        val t = a[n]
        a[n] = a[k]
        a[k] = t
    }
    return a
}