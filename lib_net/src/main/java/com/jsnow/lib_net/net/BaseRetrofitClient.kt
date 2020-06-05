package com.jsnow.lib_net.net

import com.jsnow.lib_net.BuildConfig
import com.jsnow.lib_net.interceptor.CommonInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Author:bincheng
 * Date:2020/6/5 - 5:06 PM
 * Description:BaseRetrofitClient
 */
abstract class BaseRetrofitClient {
    companion object {
        private const val TIME_OUT = 5
        private const val BASE_URL = "https://www.wanandroid.com"
    }

    private val client: OkHttpClient
        get() {
            val builder = OkHttpClient.Builder()
            val logging = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                logging.level = HttpLoggingInterceptor.Level.BODY
            }
            builder.addInterceptor(logging)
                .addInterceptor(CommonInterceptor())
                .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            handleBuilder(builder)
            return builder.build()
        }

    fun <T> getRetrofitService(servicesClass: Class<T>): T {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(servicesClass)
    }

    protected abstract fun handleBuilder(builder: OkHttpClient.Builder)

}