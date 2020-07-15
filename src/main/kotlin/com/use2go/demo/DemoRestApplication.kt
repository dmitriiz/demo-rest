package com.use2go.demo

import com.use2go.demo.service.impl.DemoServiceImpl
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootApplication
class DemoRestApplication

fun main(args: Array<String>) {
	runApplication<DemoRestApplication>(*args)
}

@Configuration
class AppConfig {
	@Bean
	fun demoService() = DemoServiceImpl()
}