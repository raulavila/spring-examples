package com.raulavila.springbootexample.greeting

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController(
        val greetingService: GreetingService
) {

    @GetMapping("/greeting/{personId}")
    fun greeting(@PathVariable personId: Int) =
            greetingService.getGreeting(personId)

}