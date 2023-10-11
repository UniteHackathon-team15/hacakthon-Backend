package com.hackathon.backend.global.security.principle

import com.hackathon.backend.domain.user.exception.UserNotFoundException
import com.hackathon.backend.domain.user.persistence.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class CustomDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(accountId: String): UserDetails {
        val user = userRepository.findByAccountId(accountId)
            ?: throw UserNotFoundException
        return CustomDetailsImpl(user)
    }

}