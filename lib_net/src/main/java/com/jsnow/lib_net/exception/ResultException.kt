package com.jsnow.lib_net.exception

import java.lang.Exception

/**
 * Author:bincheng
 * Date:2020/6/5 - 4:25 PM
 * Description:ResultException
 */
class ResultException(val errCode: String?, val msg: String?) : Exception(msg)