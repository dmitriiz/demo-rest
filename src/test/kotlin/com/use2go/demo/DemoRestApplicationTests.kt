package com.use2go.demo

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.restdocs.JUnitRestDocumentation
import org.springframework.test.web.reactive.server.WebTestClient


@SpringBootTest
class DemoRestApplicationTests {

	@Autowired
	private lateinit var context: ApplicationContext

//	@Rule
//	private lateinit val restDocumentation: JUnitRestDocumentation


	private lateinit var webClient: WebTestClient

	@BeforeEach
	internal fun setUp() {
		webClient = WebTestClient
				.bindToApplicationContext(context)
				.configureClient()
				.baseUrl("http://localhost:8080")
				.build()
	}

	@Test
	fun testGetNoUsers() {
		webClient.get().exchange()
				.expectStatus().isOk
				.expectBody().json("[]")
	}

}
