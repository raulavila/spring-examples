package com.raulavila.di

import org.springframework.stereotype.Service

class GreetingService(
        val personRepository: PersonRepository,
        val capitalizer: Capitalizer
) {

    fun getGreeting(personId: Int): String {
        val person = personRepository.getPerson(personId)!!
        return capitalizer.capitalize("Hello ${person.name}")
    }
}