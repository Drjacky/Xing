package app.web.drjackycv.data.repos.datasource

import app.web.drjackycv.data.base.Utils.Companion.getJson
import app.web.drjackycv.data.repos.entity.ItemResponse
import app.web.drjackycv.data.repos.entity.ReposResponseFactory.Companion.providesItemsResponse
import app.web.drjackycv.data.repos.remote.ReposApi
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@RunWith(MockitoJUnitRunner::class)
class ReposRemoteDataSourceUnitTest {

    private lateinit var reposRemoteDataSource: ReposRemoteDataSource
    lateinit var mockWebServer: MockWebServer
    lateinit var retrofit: Retrofit
    lateinit var reposApi: ReposApi

    /*@Mock
    private lateinit var reposApi: ReposApi*/

    @Mock
    private lateinit var mockedCall: Call<List<ItemResponse>>

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        val okHttpClient = OkHttpClient.Builder().build()
        retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(mockWebServer.url("/").toString())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        reposApi = retrofit.create(ReposApi::class.java)

        reposRemoteDataSource = ReposRemoteDataSource(reposApi)
    }

    @Test
    fun `getRepos should return a list of repositories`() {
        val path = "/repos"
        val item = providesItemsResponse()
        val call = reposApi.getRepos()
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(getJson("json/repo.json"))

        /*try {
            val response: Response<List<ItemResponse>> = call.execute()
            val responseBody: List<ItemResponse>? = response.body()
            assertTrue(response.isSuccessful && responseBody?.isEmpty()?.not() == true)
        } catch (e: IOException) {
            e.printStackTrace()
        }*/

        mockWebServer.enqueue(mockResponse)
        val testObserver = Single.just(reposApi.getRepos()).test()
        testObserver.awaitTerminalEvent(2, TimeUnit.SECONDS)
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)

        val request = mockWebServer.takeRequest()

        Assert.assertEquals(path, request.path)
    }

}