package com.raulavila.springrestapi.person

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Person(
        @Id @GeneratedValue
        val id: Int?= null,
        val name: String = ""
)

interface PersonRepository : JpaRepository<Person, Int>