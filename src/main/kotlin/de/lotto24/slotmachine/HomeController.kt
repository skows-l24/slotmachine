package de.lotto24.slotmachine

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@Api(description = "Controller that redirects to the swagger ui")
class HomeController {
    @RequestMapping("/")
    @ApiOperation(value = "Redirects to Swagger UI", notes = "Redirects to the fancy Swagger UI")
    fun home(): String {
        return "redirect:swagger-ui.html"
    }
}