package com.hackathon.backend.global.error

import com.hackathon.backend.global.error.response.ErrorResponse

open class CustomException(val errorResponse: ErrorResponse) : RuntimeException() {

    val status: Int
        get() = errorResponse.status

    override val message
        get() = errorResponse.message

}