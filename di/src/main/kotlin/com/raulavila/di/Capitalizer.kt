package com.raulavila.di

import org.springframework.stereotype.Component

class Capitalizer {
    fun capitalize(text: String): String = text.toUpperCase()
}