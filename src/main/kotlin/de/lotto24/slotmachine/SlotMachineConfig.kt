package de.lotto24.slotmachine

import de.lotto24.slotmachine.controller.Storage
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SlotMachineConfig {

    @Bean
    fun storage(): Storage = Storage()
}