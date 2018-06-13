package com.raulavila.di.ioc

import com.raulavila.di.Capitalizer
import com.raulavila.di.GreetingService
import com.raulavila.di.PersonRepository
import org.springframework.context.annotation.Bean

class MyApplicationContext {

    @Bean
    fun personRepository() = PersonRepository()

    @Bean
    fun capitalizer() = Capitalizer()

    @Bean
    fun greetingService(
            personRepository: PersonRepository,
            capitalizer: Capitalizer
    ): GreetingService {
        return GreetingService(personRepository, capitalizer)
    }
}