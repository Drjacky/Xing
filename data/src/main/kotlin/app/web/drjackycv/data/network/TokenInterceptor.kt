package app.web.drjackycv.data.network

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

private const val CLIENT_ID = "c13a45e5571e42f7221c"
private const val CLIENT_SECRET = "3d3af9080fe6b3b6411c7c72d5040d830be9fb17"


class TokenInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val accessToken = "39733f0bcc3a6a4ffff62b45b1a3cf59ff7e215b"

        val request = chain.request()
        val requestBuilder = request.newBuilder()
            .header("Authorization", Credentials.basic(CLIENT_ID, CLIENT_SECRET))
            .method(request.method, request.body)

        return chain.proceed(requestBuilder.build())
    }

}