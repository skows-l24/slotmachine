package de.lotto24.slotmachine

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Api(description = "Controller that returns Hello world")
class HelloController {

    @GetMapping(value = "/hello")
    @ApiOperation(value = "Return Hello world",
            notes = "Does nothing more than returning Hello World",
            response = String::class)
    @ApiResponse(code = 200, message = "Says hello world")
    fun hello(): ResponseEntity<String> {
        return ResponseEntity.ok("Hello world")
    }
}