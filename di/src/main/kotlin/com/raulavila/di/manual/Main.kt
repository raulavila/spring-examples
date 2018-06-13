package com.raulavila.di.manual

import com.raulavila.di.Capitalizer
import com.raulavila.di.GreetingService
import com.raulavila.di.PersonRepository

fun main(args: Array<String>) {
    val capitalizer = Capitalizer()
    val personRepository = PersonRepository()
    val greetingService = GreetingService(personRepository, capitalizer)

    println(greetingService.getGreeting(1))
}