package com.example.testdemo

import org.springframework.data.repository.CrudRepository

interface MovieRepository : CrudRepository<Movie, String>