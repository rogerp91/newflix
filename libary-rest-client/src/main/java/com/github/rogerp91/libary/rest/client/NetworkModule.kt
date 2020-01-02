package com.github.rogerp91.libary.rest.client

import com.github.rogerp91.libary.rest.client.util.Const
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkModule {

    fun wrapperRetrofit(): WrapperClient {
        return WrapperClient(
            getRetrofit(
                getOkHttpClient(
                    getHttpLoggingInterceptor(),
                    getHttpCustomInterceptor()
                )
            )
        )
    }

    fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Const.BASE_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun getOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        movieHttpLoggingInterceptor: MovieHttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(movieHttpLoggingInterceptor)
            .readTimeout(150, TimeUnit.SECONDS)
            .connectTimeout(150, TimeUnit.SECONDS)
            .build()
    }

    fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        return logger
    }

    fun getHttpCustomInterceptor(): MovieHttpLoggingInterceptor = MovieHttpLoggingInterceptor()

    fun getMockRetrofit() =
        getRetrofit(getOkHttpClient(getHttpLoggingInterceptor(), getHttpCustomInterceptor()))
}
