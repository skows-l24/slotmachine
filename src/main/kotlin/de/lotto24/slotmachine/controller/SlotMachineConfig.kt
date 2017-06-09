package de.lotto24.slotmachine.controller

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SlotMachineConfig {
    @Bean
    fun get(): Storage = Storage()
}