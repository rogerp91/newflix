package com.github.rogerp91.common.data.source.remote

import com.github.rogerp91.common.data.source.DataSource
import com.github.rogerp91.common.data.source.remote.dto.ResultDto
import com.github.rogerp91.common.util.test.ResultEntityTest.getMoviesResult
import com.github.rogerp91.libary.rest.client.NetworkModule
import com.github.rogerp91.libary.rest.client.WrapperClient
import com.google.gson.Gson
import io.reactivex.subscribers.TestSubscriber
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class MovieRemoteDataSourceTest {

    private lateinit var wrapperClient: WrapperClient
    private lateinit var webServer: MockWebServer

    @Before
    fun setUp() {
        val networkModule = NetworkModule()
        wrapperClient = WrapperClient(networkModule.getMockRetrofit())

        webServer = MockWebServer()
        webServer.start(3000)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        webServer.shutdown()
    }

    @Test
    fun name() {
        val testSubscriber: TestSubscriber<List<ResultDto>> = TestSubscriber()

        val mockedResponse = MockResponse()
        mockedResponse.setResponseCode(200)
        mockedResponse.setBody(Gson().toJson(getMoviesResult()))
        webServer.enqueue(mockedResponse)

        val remote: DataSource<ResultDto> = MovieRemoteDataSource(wrapperClient)
        remote.get().subscribe(testSubscriber)
    }
}