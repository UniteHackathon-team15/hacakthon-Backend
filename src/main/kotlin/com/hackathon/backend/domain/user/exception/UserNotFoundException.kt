package com.hackathon.backend.domain.user.exception

import com.hackathon.backend.global.error.CustomException
import com.hackathon.backend.global.error.ErrorCode

object UserNotFoundException : CustomException(
    ErrorCode.USER_NOT_FOUND
)