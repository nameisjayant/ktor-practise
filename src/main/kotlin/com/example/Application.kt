package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.serialization.gson.*
import io.ktor.server.plugins.contentnegotiation.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.installPlugins(){
    install(ContentNegotiation){
        gson {
            setPrettyPrinting()
        }
    }
}

fun Application.module() {
    installPlugins()
    configureRouting()
}
