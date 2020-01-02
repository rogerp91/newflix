package com.github.rogerp91.libary.rest.client

import com.github.rogerp91.libary.rest.client.util.Const
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun WrapperRetrofit(retrofit: Retrofit): WrapperClient {
        return WrapperRetrofit(retrofit)
    }

    @Singleton
    @Provides
    fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Const.BASE_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttpClient(getHttpLoggingInterceptor(), getHttpCustomInterceptor()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
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

    @Provides
    fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        return logger
    }

    @Provides
    fun getHttpCustomInterceptor(): MovieHttpLoggingInterceptor = MovieHttpLoggingInterceptor()
}
