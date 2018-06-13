package com.raulavila.springbootexample.greeting

import org.springframework.stereotype.Repository

data class Person(
        val id: Int,
        val name: String
)

interface PersonRepository {
    fun getPerson(id: Int): Person?
}

@Repository
class InMemoryPersonRepository : PersonRepository {
    private val personById = mapOf<Int, Person>(
            1 to Person(1, "Raul"),
            2 to Person(2, "Jon"),
            3 to Person(3, "Lewis")
    )

    override fun getPerson(id: Int): Person? = personById[id]
}

