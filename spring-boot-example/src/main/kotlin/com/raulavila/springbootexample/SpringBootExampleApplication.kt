package com.raulavila.springbootexample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringBootExampleApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootExampleApplication::class.java, *args)
}