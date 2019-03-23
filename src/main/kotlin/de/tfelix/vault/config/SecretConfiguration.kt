package de.tfelix.vault.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

/**
 * This reads the config from Vault like:
 * /secret/{application}/{profile}
 * /secret/{application}
 * /secret/{default-context}/{profile}
 * /secret/{default-context}
 */

@Configuration
data class SecretConfiguration(
    @Value("\${config.name}")
    val name: String
)