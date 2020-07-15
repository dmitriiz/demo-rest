package com.use2go.demo.endpoint

import com.use2go.demo.service.DemoService
import org.springframework.web.bind.annotation.*

@RestController
class RootEndpoint {

    private val demoService: DemoService

    constructor(demoService: DemoService) {
        this.demoService = demoService
    }

    @GetMapping
    fun getUsers() = demoService.getUsers()

    @PostMapping("/{name}")
    fun newUser(@PathVariable name: String) = demoService.newUser(name)

    @PutMapping("/{id}")
    fun knockUser(@PathVariable id: Int) = demoService.knockUser(id)

}