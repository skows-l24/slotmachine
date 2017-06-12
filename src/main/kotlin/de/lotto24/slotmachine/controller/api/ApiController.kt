package de.lotto24.slotmachine.controller.api

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author skows (initial creation).
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@RestController
@RequestMapping(path = arrayOf("api"), produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
annotation class ApiController