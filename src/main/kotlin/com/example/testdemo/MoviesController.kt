package com.example.testdemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movies")
class MoviesController {
    @GetMapping
    fun listMessages() = listOf(
        Movie(1, "Harry Potter y la Piedra Filosofal", 2001, MovieStatus.ACTIVE),
        Movie(2, "John Wick", null, MovieStatus.ACTIVE),
        Movie(3, "Andrea", 2005, MovieStatus.ACTIVE),
    )
}