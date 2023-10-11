package com.hackathon.backend.domain.user.exception

import com.hackathon.backend.global.error.CustomException
import com.hackathon.backend.global.error.ErrorCode

object PasswordMisMatchException : CustomException(
    ErrorCode.PASSWORD_MIS_MATCH
)