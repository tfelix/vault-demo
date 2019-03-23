package de.tfelix.vault.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.vault.annotation.VaultPropertySource

@VaultPropertySource(
    value = ["aws/creds/s3"],
    propertyNamePrefix = "aws.",
    renewal = VaultPropertySource.Renewal.RENEW
)
@Configuration
class AppConfiguration