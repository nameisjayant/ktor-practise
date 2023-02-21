package com.example.plugins

import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    val userList = mutableListOf<User>()
    routing {
        get("/") {
            call.respondText(
                "Hello how are you?",
                status = HttpStatusCode.OK,
                contentType = ContentType.Text.CSV
            ){
               print(this.status)
            }
            call.respond(
                status = HttpStatusCode.OK,
                message = ""
            )
        }
        get("/user") {
            call.respond(
                userList
            )
        }
        post("/user"){
            val user = call.receive<User>()
            userList.add(user)
            call.respond(user)
        }
    }
}


data class User(
    val name: String, val age: Int
)

