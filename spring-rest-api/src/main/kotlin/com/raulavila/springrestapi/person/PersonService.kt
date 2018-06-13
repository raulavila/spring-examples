package com.raulavila.springrestapi.person

import com.raulavila.springrestapi.audit.AuditService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PersonService(
        val personRepository: PersonRepository,
        val auditService: AuditService
) {

    fun getAll(): List<Person> {
        return personRepository.findAll().toList()
    }

    fun addPerson(name: String): Person {
        val person = Person(name =name)

        personRepository.save(person)

        auditService.audit("Added new person with ID: ${person.id} and NAME: ${person.name}")

        return person
    }

    fun updatePerson(person: Person): Person {
        val updatedPerson = personRepository.save(person)
        auditService.audit("Update person with ID: ${person.id}, changed NAME: ${person.name}")
        return updatedPerson
    }
}