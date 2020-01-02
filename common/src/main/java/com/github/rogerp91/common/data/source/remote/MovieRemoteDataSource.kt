package com.github.rogerp91.common.data.source.remote

import com.github.rogerp91.common.data.source.DataSource
import com.github.rogerp91.common.data.source.local.entity.ResultEntity
import io.reactivex.Flowable

open class MovieRemoteDataSource(
) : DataSource<ResultEntity> {

    override fun get(): Flowable<List<ResultEntity>> {
        TODO("")
    }

    override fun get(id: String): Flowable<ResultEntity> {
        TODO("")
    }

    override fun save(model: ResultEntity): Long? {
        TODO("")
    }

    override fun refresh() {
        // empty
    }
}
