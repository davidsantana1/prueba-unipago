package com.example.testdemo

import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movies")
class MoviesController(private val service: MovieService) {
    @GetMapping
    fun listMovies() = service.findMovies()
    @PostMapping
    fun addMovie(@RequestBody movie: Movie) = service.save(movie)
    @GetMapping("/{id}")
    fun getMovie(@PathVariable id: String): ResponseEntity<Movie> = service.findMovieById(id).toResponseEntity()
    @PutMapping("/{id}")
    fun updateMovieById(@PathVariable id: String, @RequestBody movie: Movie): ResponseEntity<Movie> = service.updateMovieById(id, movie).toResponseEntity()
    @DeleteMapping("/{id}")
    fun deleteMovieById(@PathVariable id: String): ResponseEntity<Movie> = service.deleteMovieById(id).toResponseEntity()

    private fun Movie?.toResponseEntity(): ResponseEntity<Movie> =
        this?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
}