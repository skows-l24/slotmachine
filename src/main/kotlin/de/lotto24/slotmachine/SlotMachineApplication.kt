package de.lotto24.slotmachine

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication

@EnableAutoConfiguration
@SpringBootApplication
class SlotMachineApplication

fun main(args: Array<String>) {
    SpringApplication.run(SlotMachineApplication::class.java, *args)
}
