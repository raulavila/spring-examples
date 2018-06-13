package com.raulavila.springrestapi.person

import org.springframework.web.bind.annotation.*

@RestController("/person")
class PersonController(
        val personService: PersonService
) {

    @GetMapping
    fun getAll(): List<Person> {
        return personService.getAll()
    }

    @PostMapping
    fun addPerson(
            @RequestBody
            personRequest: PersonRequest): Person {
        return personService.addPerson(personRequest.name)
    }

    @PatchMapping
    fun updatePerson(
            @RequestBody
            person: Person): Person {
        return personService.updatePerson(person)
    }
}

data class PersonRequest(val name: String = "")