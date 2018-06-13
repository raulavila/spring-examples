package com.raulavila.di.ioc

import com.raulavila.di.GreetingService
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main(args: Array<String>) {
    val context = AnnotationConfigApplicationContext (MyApplicationContext::class.java)

    val greetingService = context.getBean(GreetingService::class.java)

    println(greetingService.getGreeting(1))
}