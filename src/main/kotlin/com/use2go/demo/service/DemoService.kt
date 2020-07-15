package com.use2go.demo.service

import com.use2go.demo.model.User
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface DemoService {
    fun getUsers(): Flux<User>
    fun newUser(name: String): Mono<User>
    fun knockUser(id: Int): Mono<Int>
}