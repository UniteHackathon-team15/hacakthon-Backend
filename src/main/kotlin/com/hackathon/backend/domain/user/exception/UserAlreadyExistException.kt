package com.hackathon.backend.domain.user.exception

import com.hackathon.backend.global.error.CustomException
import com.hackathon.backend.global.error.ErrorCode

object UserAlreadyExistException : CustomException(
    ErrorCode.USER_ALREADY_EXIST
)