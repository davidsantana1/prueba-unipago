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

    fun updateMovieById(id: String, movie: Movie): Movie? {
            return if (db.existsById(id)) {
                db.save(movie.copy(id = id))
            } else {
                null
            }
          }
    fun deleteMovieById(id: String): Movie? {
            val movie = findMovieById(id)
            return if (movie != null) {
                db.save(movie.copy(status = "deleted"))
            } else {
                null
            }
          }

    fun save(movie: Movie): Movie = db.save(movie)
}