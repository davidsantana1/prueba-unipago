package com.example.testdemo

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movies")
class MoviesController(private val service: MovieService) {
    @GetMapping
    fun listMessages() = service.findMovies()
    @PostMapping
    fun addMovie(@RequestBody movie: Movie) = service.save(movie)
    @GetMapping("/{id}")
    fun getMovie(@PathVariable id: String): ResponseEntity<Movie> =
        service.findMovieById(id).toResponseEntity()

    private fun Movie?.toResponseEntity(): ResponseEntity<Movie> =
        this?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
}