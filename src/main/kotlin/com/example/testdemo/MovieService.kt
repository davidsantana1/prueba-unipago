package com.example.testdemo

import org.springframework.stereotype.Service
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import java.util.UUID

@Service
class MovieService(private val db: JdbcTemplate) {
    fun findMovies(): List<Movie> = db.query("select * from movies") { response, _ ->
        Movie(
            response.getString("id"),
            response.getString("title"),
            response.getObject("release_year") as? Int,
            response.getString("status")
        )
    }

    fun findMovieById(id: String): Movie? = db.query("select * from movies where id = ?", id) { response, _ ->
        Movie(
            response.getString("id"),
            response.getString("title"),
            response.getObject("release_year") as? Int,
            response.getString("status")
        )
    }.singleOrNull()

    fun save(movie: Movie): Movie {
        val id = movie.id ?: UUID.randomUUID().toString()
        db.update(
            "insert into movies values ( ?, ?, ?, ? )",
            id, movie.title, movie.releaseYear, movie.status
        )
        return movie.copy(id = id)
    }
}