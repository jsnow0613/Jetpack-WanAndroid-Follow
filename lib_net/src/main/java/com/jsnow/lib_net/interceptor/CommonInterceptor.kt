package com.jsnow.lib_net.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Author:bincheng
 * Date:2020/6/5 - 4:56 PM
 * Description:CommonInterceptor
 */
class CommonInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = addHeaders(request.newBuilder())
        val response = chain.proceed(builder)

        return response
    }

    fun addHeaders(builder: Request.Builder): Request {
        return builder.addHeader("Content_Type", "application/json")
            .addHeader("charset", "UTF-8").build()
    }
}