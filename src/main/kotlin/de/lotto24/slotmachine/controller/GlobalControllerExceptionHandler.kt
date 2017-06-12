package de.lotto24.slotmachine.controller


// Not active, solution based on annotations directly at OptionNotFoundException!
// @ControllerAdvice
internal class GlobalControllerExceptionHandler {
    // @ResponseStatus(HttpStatus.NOT_FOUND)
    // @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: Exception) {
        println (e)
        // Nothing to do
    }
}