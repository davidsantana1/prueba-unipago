package com.example.testdemo

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import java.util.UUID

@Service
class MovieService(private val db: MovieRepository) {
    fun findMovies(): List<Movie> = db.findAll().toList()

    fun findMovieById(id: String): Movie? = db.findByIdOrNull(id)

    fun save(movie: Movie): Movie = db.save(movie)
}