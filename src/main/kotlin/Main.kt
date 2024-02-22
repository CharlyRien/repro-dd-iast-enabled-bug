package me.chosante

import kotlinx.serialization.Serializable
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

fun main(vararg args: String) {
    SpringApplication.run(App::class.java, *args)
}

@SpringBootApplication
open class App

@RestController
@RequestMapping("/bug")
class Controller {
    @GetMapping
    fun get(): ResponseEntity<SerializableByKotlinX> =
        ResponseEntity.ok(SerializableByKotlinX(2))
}

@Serializable
data class SerializableByKotlinX(val data: Int)