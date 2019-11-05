package dk.nodes.template.network.util

import dk.nodes.template.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val ts = System.currentTimeMillis().toString()
        val url = request.url().newBuilder()
            .addQueryParameter("hash", generateHash(ts))
            .addQueryParameter("apikey", BuildConfig.PUBLIC_KEY)
            .addQueryParameter("ts", ts)
            .build()

        return chain.proceed(
            request.newBuilder()
                .header("Accept", "application/json")
                .url(url)
                .build()
        )
    }

    private fun generateHash(ts: String): String {
        try {
            val md = MessageDigest.getInstance("MD5")
            val messageDigest = md.digest(
                ts.toByteArray() +
                    BuildConfig.PRIVATE_KEY.toByteArray() +
                    BuildConfig.PUBLIC_KEY.toByteArray()
            )

            val no = BigInteger(1, messageDigest)

            var hashtext = no.toString(16)
            while (hashtext.length < 32) {
                hashtext = "0$hashtext"
            }
            return hashtext
        } catch (e: NoSuchAlgorithmException) {
            throw IOException(e)
        }
    }
}