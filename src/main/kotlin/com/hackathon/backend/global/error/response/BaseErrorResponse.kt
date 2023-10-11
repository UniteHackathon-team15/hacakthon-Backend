package com.hackathon.backend.global.error.response

import com.hackathon.backend.global.error.CustomException

class BaseErrorResponse (
    val status: Int,
    val message: String
) {

    companion object {
        fun of(e: CustomException): BaseErrorResponse {
            return BaseErrorResponse(
                status = e.status,
                message = e.message
            )
        }
    }
}