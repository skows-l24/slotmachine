package de.lotto24.slotmachine.dsl

/**
 * Example class for a DSL based on Kotlin. Just playing around a little bit..
 *
 * @author skows (initial creation).
 */
class Configuration(var items: MutableList<OptionGroup> = mutableListOf())

class OptionGroup(var name: String = "", var options: MutableList<Option> = mutableListOf())

class Option(var value: String = "")

fun configuration(init: Configuration.() -> Unit): Configuration {
    val configuration = Configuration()
    configuration.init()
    return configuration
}

fun Configuration.optionGroup(init: OptionGroup.() -> Unit) {
    val optionGroup = OptionGroup()
    optionGroup.init()
    this.items.add(optionGroup)
}

fun OptionGroup.name(name: String) {
    this.name = name
}

fun OptionGroup.options(init: Option.() -> Unit) {
    val option = Option()
    option.init()
    this.options.add(option)
}

fun Option.option(value: String) {
    this.value = value
}

val config =

configuration {
    optionGroup {
        name("Team B")
        options {
            option("Sascha")
            option("Sebastian")
            option("Yalda")
            option("Christian")
            option("Benjamin")
            option("Dennis")
            option("Oliver")
        }
    }
    optionGroup {
        name("Team A")
        options {
            option("Basti")
            option("Arne")
            option("Stefan")
            // ...
        }
    }
}
