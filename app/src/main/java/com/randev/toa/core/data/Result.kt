package com.randev.toa.core.data

/**
 * @author Raihan Arman
 * @date 10/09/22
 */

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: Throwable) : Result<Nothing>()
}
