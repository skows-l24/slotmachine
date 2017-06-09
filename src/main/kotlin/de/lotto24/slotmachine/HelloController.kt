package de.lotto24.slotmachine

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@EnableAutoConfiguration
class HelloController {

    @GetMapping(value = "/")
    fun hello(): String {
        return "Hello World!"
    }
}