package de.tfelix.vault.controller

import de.tfelix.vault.config.AwsCredsConfig
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.vault.core.VaultTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.vault.support.VaultResponseSupport


@Controller
class VaultController(
    private val vaultTemplate: VaultTemplate,
    private val awsCredsConfig: AwsCredsConfig
) {

  @GetMapping("/supersecret")
  @ResponseBody
  fun getASuperSecretValue(): Map<String, Any>? {
    val content = vaultTemplate.read("mysecret")

    //  Also possible to inject values into config class:
    // val response = operations.read(userId, Person::class.java)
    // return response.getBody()

    return content.data
  }

  @GetMapping("aws")
  @ResponseBody
  fun getAwsCreds(): AwsCredsConfig {
    return awsCredsConfig
  }

  @PostMapping("/supersecret")
  @ResponseBody
  fun postASecret(@RequestBody content: String): ResponseEntity<*> {
    val payload = mapOf("mysecret" to content)

    vaultTemplate.write("mysecret", payload)

    return ResponseEntity.status(HttpStatus.CREATED).body(null)
  }
}