package de.lotto24.slotmachine;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "Controller that returns Hello world")
class JavaHelloController {

    @GetMapping(value = "/helloJava")
    @ApiOperation(value = "Return Hello world",
            notes = "Does nothing more than returning Hello World",
            response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success1", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized1"),
            @ApiResponse(code = 403, message = "Forbidden1"),
            @ApiResponse(code = 404, message = "Not Found1"),
            @ApiResponse(code = 500, message = "Failure1")})
    public String hello() {
        return "Hello world";
    }
}