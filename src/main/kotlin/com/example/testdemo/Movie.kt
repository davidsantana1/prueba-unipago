package com.example.testdemo

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("MOVIES")
data class Movie (val title: String, val releaseYear:Int?, val status: String?, @Id val id: String? = null)