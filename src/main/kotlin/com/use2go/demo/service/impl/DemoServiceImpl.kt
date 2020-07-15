package com.use2go.demo.service.impl

import com.use2go.demo.model.User
import com.use2go.demo.service.DemoService
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.security.InvalidParameterException
import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.collections.HashMap

class DemoServiceImpl : DemoService {

    private val userId = AtomicInteger();
    private val usersById = HashMap<Int, User>()
    private val usersByName = HashMap<String, User>()

    override fun getUsers() = Flux.fromIterable(usersById.values)

    override fun newUser(name: String): Mono<User> {
        Objects.requireNonNull(name)
        if (usersByName.containsKey(name)) throw InvalidParameterException()
        val user = User(userId.getAndIncrement(), name, AtomicInteger())
        usersById[user.id] = user
        usersByName[user.name] = user
        return Mono.just(user)
    }

    override fun knockUser(id: Int): Mono<Int> {
        Objects.requireNonNull(id)
        val user = usersById[id] ?: throw UnsupportedOperationException()
        return Mono.just(user.counter.incrementAndGet())
    }
}