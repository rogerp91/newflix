package com.github.rogerp91.libary.rest.client

import com.github.rogerp91.libary.rest.client.util.Const
import okhttp3.Interceptor
import okhttp3.Response

class MovieHttpLoggingInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder().addQueryParameter("api_key", Const.TOKEN).build()
        request = request.newBuilder()
            .url(url)
            .addHeader("Content-Type", "application/json")
            .build()

        return chain.proceed(request)
    }
}