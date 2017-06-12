package de.lotto24.slotmachine.controller.api

import de.lotto24.slotmachine.controller.Storage
import de.lotto24.slotmachine.extensions.pickRandom
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

/**
 * @author skows (initial creation).
 */
@ApiController
@Api(description = "Controller that returns a subset of a provided list")
class PickController {

    @Autowired
    lateinit var storage: Storage

    @PostMapping("/pick")
    @ApiOperation(value = "Get a list of saved options by optionName")
    fun <T> pick(@RequestBody pickData: PickData<T>) = pickData.pickRandom(pickData.quantity)

}

// ----------------------------------------
// Data Classes for Input Data
// ----------------------------------------
data class PickData<T>(val options: List<T>, val quantity: Int) {
    fun pickRandom(quantity: Int) = options.pickRandom(quantity)
}

