package com.hackathon.backend.domain.user.service

import com.hackathon.backend.domain.user.exception.UserAlreadyExistException
import com.hackathon.backend.domain.user.persistence.UserEntity
import com.hackathon.backend.domain.user.persistence.UserRepository
import com.hackathon.backend.domain.user.presentation.dto.request.SignUpRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserSignUpService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun execute(request: SignUpRequest) {

        if (userRepository.existsByAccountId(request.accountId)) {
            throw UserAlreadyExistException
        }

        userRepository.save(
            UserEntity(
                accountId = request.accountId,
                password = passwordEncoder.encode(request.password),
                name = request.name
            )
        )
    }
}