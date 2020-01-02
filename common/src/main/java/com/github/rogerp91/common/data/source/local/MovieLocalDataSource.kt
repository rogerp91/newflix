package com.github.rogerp91.common.data.source.local

import com.github.rogerp91.common.data.source.DataSource
import com.github.rogerp91.common.data.source.local.entity.ResultEntity
import io.reactivex.Flowable

open class MovieLocalDataSource(
    private val dao: MovieDao
) : DataSource<ResultEntity> {

    override fun get(): Flowable<List<ResultEntity>> {
        return Flowable.just(dao.getTv())
    }

    override fun get(id: String): Flowable<ResultEntity> {
        var resultEntity = dao.getTv(id.toLong())
        if (resultEntity == null) {
            resultEntity = ResultEntity.EMPTY
        }
        return Flowable.just(resultEntity)
    }

    override fun save(model: ResultEntity): Long? {
        return dao.insertTv(model)
    }

    override fun refresh() {
        // empty
    }
}
