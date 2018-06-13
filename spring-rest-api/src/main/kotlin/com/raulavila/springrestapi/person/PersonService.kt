package com.raulavila.springrestapi.person

import com.raulavila.springrestapi.audit.AuditService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.EntityManagerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionDefinition
import org.springframework.transaction.support.DefaultTransactionDefinition

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

    open fun updatePerson(person: Person): Person {
        val updatedPerson = personRepository.save(person)
        auditService.audit("Update person with ID: ${person.id}, changed NAME: ${person.name}")
        return updatedPerson
    }
}

//@Service
//class TransactionalPersonService(
//        personRepository: PersonRepository,
//        auditService: AuditService
//): PersonService(personRepository, auditService) {
//
//    @Autowired
//    lateinit var transactionManager: PlatformTransactionManager
//
//    override fun updatePerson(person: Person): Person {
//        println("-------- Updating person in transactional service")
//
//        val txDef = DefaultTransactionDefinition()
//        val txStatus = transactionManager.getTransaction(txDef)
//        try {
//            val savedPerson = super.updatePerson(person)
//
//            transactionManager.commit(txStatus)
//
//            return savedPerson
//        } catch (ex: Exception) {
//            transactionManager.rollback(txStatus);
//
//            throw ex
//        }
//    }
//}