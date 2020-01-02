package com.github.rogerp91.libary.rest.client.api

import com.github.rogerp91.common.data.source.remote.dto.MoviesDto
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("3/movie/popular")
    fun searchMovies(@Query("q") query: String): Flowable<MoviesDto>
}