package com.hackathon.backend.global.exception

import com.hackathon.backend.global.error.CustomException
import com.hackathon.backend.global.error.ErrorCode

object InvalidTokenException : CustomException(
    ErrorCode.INVALID_TOKEN
)