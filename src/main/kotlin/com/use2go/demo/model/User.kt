package com.use2go.demo.model

import java.util.concurrent.atomic.AtomicInteger

data class User (var id: Int, var name: String, var counter: AtomicInteger)
