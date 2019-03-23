package de.tfelix.vault.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class AwsCredsConfig(
    // inject the actual values
    @Value("\${aws.access_key}")
    private val awsAccessKey: String? = null,

    @Value("\${aws.secret_key}")
    private val awsSecretKey: String? = null
)