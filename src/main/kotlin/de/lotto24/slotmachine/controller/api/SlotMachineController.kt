package de.lotto24.slotmachine.controller.api

import de.lotto24.slotmachine.OptionNotFoundException
import de.lotto24.slotmachine.controller.Storage
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * @author skows (initial creation).
 */
@ApiController
@Api(description = "Controller that handles options. yeah ha")
class SlotMachineController {

    @Autowired
    lateinit var storage: Storage

    @PostMapping("/pick")
    fun <T> pick(@RequestBody pickData: PickData<T>) = pickData.options.pickRandom(pickData.quantity)

    @GetMapping("/options/{optionName}")
    @ApiOperation(value = "Find saved options by optionName", response = Option::class)
    @ApiResponses(
            ApiResponse(code = 404, message = "Option not found by optionName", response = OptionNotFoundException::class))
    fun getOptionByName(@PathVariable optionName: String): Option = storage.get(optionName)

    @GetMapping("/options")
    @ApiOperation(value = "Find all saved options", notes = "Returns all saved options")
    fun getOptions(): Collection<Option> = storage.all

    @PostMapping("/options")
    @ApiOperation(value = "Saves options", notes = "Saves options", response = Option::class)
    fun get(@RequestBody option: Option): Option {
        storage.put(option)
        return option
    }

    @DeleteMapping("/options/{optionName}")
    @ApiOperation(value = "Deletes saved options", response = Option::class)
    @ApiResponses(
            ApiResponse(code = 404, message = "Option not found by optionName", response = OptionNotFoundException::class))
    fun delete(@PathVariable optionName: String): Option = storage.remove(optionName)

}

// ----------------------------------------
// Data Class for Input Data
// ----------------------------------------
data class PickData<T>(val options: List<T>, val quantity: Int)
data class Option(val optionName: String, val options: List<String>)


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
