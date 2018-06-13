package com.raulavila.di

import org.springframework.stereotype.Repository

class PersonRepository {
    private val personById = mapOf<Int, Person>(
            1 to Person("Raul"),
            2 to Person("Jon"),
            3 to Person("Lewis")
    )

    fun getPerson(id: Int): Person? = personById[id]
}

data class Person(val name: String)