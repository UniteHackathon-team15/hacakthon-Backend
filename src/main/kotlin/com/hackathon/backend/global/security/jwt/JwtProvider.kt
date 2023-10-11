package com.hackathon.backend.global.security.jwt

import com.hackathon.backend.domain.common.dto.TokenResponse
import com.hackathon.backend.global.security.SecurityProperties
import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class JwtProvider (
    private val securityProperties: SecurityProperties
) {

    fun receiveToken(userId: Long) = TokenResponse(
        accessToken = generateAccessToken(userId),
        accessTokenExp = LocalDateTime.now().plusSeconds(securityProperties.accessExp)
    )

    private fun generateAccessToken(userId: Long) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, securityProperties.secretKey)
            .setHeaderParam(Header.JWT_TYPE, JwtProperties.ACCESS)
            .setId(userId.toString())
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + securityProperties.accessExp * 1000))
            .compact()
}