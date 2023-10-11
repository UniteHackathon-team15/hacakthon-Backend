package com.hackathon.backend.domain.user.service

import com.hackathon.backend.domain.common.dto.TokenResponse
import com.hackathon.backend.domain.user.exception.PasswordMisMatchException
import com.hackathon.backend.domain.user.exception.UserNotFoundException
import com.hackathon.backend.domain.user.persistence.UserRepository
import com.hackathon.backend.domain.user.presentation.dto.request.SignInRequest
import com.hackathon.backend.global.security.jwt.JwtProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserSignInService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtProvider: JwtProvider
) {
    fun execute(request: SignInRequest): TokenResponse {

        val user = userRepository.findByAccountId(request.accountId)
            ?: throw UserNotFoundException

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordMisMatchException
        }

        return jwtProvider.receiveToken(user.accountId)
    }
}