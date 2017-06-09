package de.lotto24.slotmachine

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Option Not Found")
class OptionNotFoundException(optionName: String) : RuntimeException("OptionNotFoundException with optionName=" + optionName) {
    companion object {

        private val serialVersionUID = -3332292346834265371L
    }
}