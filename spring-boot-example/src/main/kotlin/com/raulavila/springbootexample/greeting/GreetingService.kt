package com.raulavila.springbootexample.greeting

import org.springframework.stereotype.Service

@Service
class GreetingService(
        val personRepository: PersonRepository,
        val textTransformer: TextTransformer
) {

    fun getGreeting(personId: Int): String {
        val person = personRepository.getPerson(personId)!!
        return textTransformer.transform("Hello ${person.name}")
    }
}