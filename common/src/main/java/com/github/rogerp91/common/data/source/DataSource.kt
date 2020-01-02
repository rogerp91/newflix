package com.github.rogerp91.common.data.source

import io.reactivex.Flowable

interface DataSource<T> {

    fun get(): Flowable<List<T>>

    fun get(id: String): Flowable<T>

    fun save(model: T): Long?

    fun refresh()
}
