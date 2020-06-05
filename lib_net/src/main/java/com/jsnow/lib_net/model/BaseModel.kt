package com.jsnow.lib_net.model

/**
 * Author:bincheng
 * Date:2020/6/5 - 4:44 PM
 * Description:BaseModel
 */
data class BaseModel<out T>(val errorCode: String, val errorMsg: String, val data: T)