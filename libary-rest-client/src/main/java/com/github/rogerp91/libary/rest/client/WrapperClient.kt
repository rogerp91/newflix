package com.github.rogerp91.libary.rest.client

import com.github.rogerp91.libary.rest.client.api.MoviesApi
import retrofit2.Retrofit
import javax.inject.Inject

class WrapperClient(
    @Inject
    private val retrofit: Retrofit
) {

    fun movie() = retrofit.create(MoviesApi::class.java)
}