package com.github.rogerp91.common.data.source.remote.api

import com.github.rogerp91.common.data.source.remote.dto.MoviesDto
import io.reactivex.Flowable
import retrofit2.http.GET

interface MoviesApi {

    @GET("3/movie/popular")
    fun searchMovies(): Flowable<MoviesDto>
}