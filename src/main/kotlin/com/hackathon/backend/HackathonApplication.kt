package com.hackathon.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class HackathonApplication

fun main(args: Array<String>) {
    runApplication<HackathonApplication>(*args)
}