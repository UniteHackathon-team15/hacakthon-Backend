package com.hackathon.backend.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank

class SignUpRequest (
    @field:NotBlank
    val accountId: String,

    @field:NotBlank
    val password: String,

    @field:NotBlank
    val name: String
)