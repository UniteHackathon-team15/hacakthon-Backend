package com.hackathon.backend.domain.common.dto

import java.time.LocalDateTime

class TokenResponse(
    val accessToken: String,
    val accessTokenExp: LocalDateTime
)