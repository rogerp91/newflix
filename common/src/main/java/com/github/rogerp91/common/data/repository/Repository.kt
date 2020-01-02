package com.github.rogerp91.common.data.repository

import io.reactivex.Flowable
import io.reactivex.Single

interface Repository<T> {

    fun get(): Flowable<List<T>>

    fun get(id: String): Single<T>

    fun save(model: T)

    fun refresh()
}
