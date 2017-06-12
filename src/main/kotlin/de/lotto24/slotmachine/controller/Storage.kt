package de.lotto24.slotmachine.controller

import de.lotto24.slotmachine.OptionNotFoundException
import de.lotto24.slotmachine.controller.api.Option
import java.util.*

/**
 * @author skows (initial creation).
 */
class Storage() {

    private val storage = HashMap<String, Option>()

    fun all(): Collection<Option> = storage.values

    fun remove(optionName: String): Option = storage.remove(optionName.toLowerCase()) ?: throw OptionNotFoundException(optionName)

    fun put(option: Option) = storage.put(option.optionName.toLowerCase(), option)

    operator fun get(optionName: String): Option = storage[optionName.toLowerCase()] ?: throw OptionNotFoundException(optionName)

    init {
        put(Option("teamb", listOf("svoge", "skows")))
        put(Option("numbers", listOf("1", "2")))
    }

}