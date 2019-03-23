package de.tfelix.vault.controller

import de.tfelix.vault.domain.Person
import de.tfelix.vault.domain.PersonRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("person")
class PersonController(
    private val personRepository: PersonRepository
) {

  @GetMapping("/")
  @ResponseBody
  fun getAll(): List<Person> {
    return personRepository.findAll().toList()
  }

  @PostMapping("/")
  @ResponseBody
  fun save(@RequestBody person: Person): ResponseEntity<Person> {
    personRepository.save(person)

    return ResponseEntity.ok(person)
  }
}