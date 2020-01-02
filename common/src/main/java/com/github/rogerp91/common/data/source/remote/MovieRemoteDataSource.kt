package com.github.rogerp91.common.data.source.remote

import com.github.rogerp91.common.data.source.DataSource
import com.github.rogerp91.common.data.source.remote.api.MoviesApi
import com.github.rogerp91.common.data.source.remote.dto.ResultDto
import com.github.rogerp91.libary.rest.client.WrapperClient
import io.reactivex.Flowable

open class MovieRemoteDataSource(
    private val wrapperClient: WrapperClient
) : DataSource<ResultDto> {

    override fun get(): Flowable<List<ResultDto>> {
        return wrapperClient.create(MoviesApi::class.java).searchMovies().map { it.results }
    }

    override fun get(id: String): Flowable<ResultDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(model: ResultDto): Long? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refresh() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
