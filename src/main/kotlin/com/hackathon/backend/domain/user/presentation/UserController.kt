package com.hackathon.backend.domain.user.presentation

import com.hackathon.backend.domain.common.dto.TokenResponse
import com.hackathon.backend.domain.user.presentation.dto.request.SignInRequest
import com.hackathon.backend.domain.user.presentation.dto.request.SignUpRequest
import com.hackathon.backend.domain.user.service.UserSignInService
import com.hackathon.backend.domain.user.service.UserSignUpService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserController(
    private val userSignUpService: UserSignUpService,
    private val userSignInService: UserSignInService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun signUp(@RequestBody request: SignUpRequest) {
        userSignUpService.execute(request)
    }

    @PostMapping("/auth")
    fun signIn(@RequestBody request: SignInRequest): TokenResponse =
        userSignInService.execute(request)
}