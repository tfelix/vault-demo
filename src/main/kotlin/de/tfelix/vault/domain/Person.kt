package de.tfelix.vault.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Person(
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    val id: Long = 0,

    val name: String,

    val age: Int
)