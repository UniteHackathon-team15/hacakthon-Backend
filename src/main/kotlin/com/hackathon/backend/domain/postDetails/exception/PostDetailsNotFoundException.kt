package com.hackathon.backend.domain.postDetails.exception

import com.hackathon.backend.global.error.CustomException
import com.hackathon.backend.global.error.ErrorCode

object PostDetailsNotFoundException : CustomException(
    ErrorCode.POST_DETAILS_NOT_FOUND
)