package com.github.rogerp91.common.data.source.remote.dto

data class MoviesDto(
    private val page: Int,
    private val totalResults: Int,
    private val totalPages: Int,
    val results: List<ResultDto>
)
