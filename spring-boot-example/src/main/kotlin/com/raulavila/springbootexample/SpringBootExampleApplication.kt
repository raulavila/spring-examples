package com.raulavila.springbootexample

import com.raulavila.springbootexample.greeting.GreetingService
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class SpringBootExampleApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootExampleApplication::class.java, *args)
}

@RestController
class GreetingController(
        val greetingService: GreetingService
) {

    @GetMapping("/greeting/{personId}")
    fun greeting(@PathVariable personId: Int) =
            greetingService.getGreeting(personId)

}