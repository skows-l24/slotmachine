package de.lotto24.slotmachine.controller.api

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import org.springframework.web.bind.annotation.GetMapping

@ApiController
@Api(description = "Controller that returns Hello Sascha")
class HelloController {

    @GetMapping(value = "/hello-foobar")
    @ApiOperation(value = "Return Foobar ... ! Hello world", notes = "Does nothing more than returning Hello World", response = String::class)
    @ApiResponse(code = 200, message = "Says hello world")
    private fun hello(): String {
        return "Hello Fooo Bar!!!"
    }
}