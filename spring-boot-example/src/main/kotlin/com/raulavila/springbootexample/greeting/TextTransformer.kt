package com.raulavila.springbootexample.greeting

import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

interface TextTransformer {
    fun transform(text: String): String
}

@Component
class Capitalizer: TextTransformer {
    override fun transform(text: String): String = text.toUpperCase()
}

@Component
class Lowercaser: TextTransformer {
    override fun transform(text: String): String = text.toLowerCase()
}