package com.jsnow.lib_net.model

import java.lang.Exception

/**
 * Author:bincheng
 * Date:2020/6/5 - 4:50 PM
 * Description:Result
 */
sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[dataa=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}