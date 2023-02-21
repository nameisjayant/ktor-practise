package com.example

import io.ktor.server.testing.*
import org.junit.Test
import kotlin.test.assertEquals


class ApplicationTest {

    @Test
    fun testRoot() = testApplication {
        assertEquals("Hello how are you?","Hello how are you?")
    }

}
