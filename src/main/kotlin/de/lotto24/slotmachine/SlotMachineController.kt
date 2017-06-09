package de.lotto24.slotmachine

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author skows (initial creation).
 */
@RestController
@RequestMapping("api/slot-machine")
class SlotMachineController {

    @PostMapping("pick")
    fun <T> pick(@RequestBody pickData: PickData<T>) = pickData.options.pickRandom(pickData.quantity)

}

// ----------------------------------------
// Data Class for Input Data
// ----------------------------------------
data class PickData<T>(val options: List<T>, val quantity: Int)


// ----------------------------------------
// Extension functions for List Interface to pick randum quantity
// ----------------------------------------

fun <T> List<T>.pickRandom(quantity: Int): List<T> {
    return this.shuffle().take(quantity)
}

fun <T> List<T>.shuffle(): List<T> {
    val a = ArrayList(this)
    var n = a.size
    while (n > 1) {
        val k = Knuth.gen.nextInt(n--)
        val t = a[n]
        a[n] = a[k]
        a[k] = t
    }
    return a
}

// Don't ask why "Knuth"
object Knuth {
    internal val gen = java.util.Random()
}
