package com.github.rogerp91.libary.rest.client

import retrofit2.Retrofit

open class WrapperClient(
    private val retrofit: Retrofit
) {

    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}