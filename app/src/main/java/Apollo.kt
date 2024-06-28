import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

val apolloClient = ApolloClient.Builder()
    .serverUrl("https://swapi-graphql.netlify.app/.netlify/functions/index")
    .okHttpClient(
        OkHttpClient.Builder()
            .addInterceptor(LoggingInterceptor())
            .build()
    )
    .build()


class LoggingInterceptor : Interceptor {
    private var mLoggingInterceptor: Interceptor? = null

    init {
        mLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
//            .setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        return mLoggingInterceptor!!.intercept(chain)
    }
}