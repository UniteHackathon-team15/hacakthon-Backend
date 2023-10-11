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

    fun receiveToken(accountId: String) = TokenResponse(
        accessToken = generateAccessToken(accountId),
        accessTokenExp = LocalDateTime.now().plusSeconds(securityProperties.accessExp)
    )

    private fun generateAccessToken(accountId: String) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, securityProperties.secretKey)
            .setSubject(accountId)
            .setHeaderParam("type", "jwt")
            .claim("type", JwtProperties.ACCESS)
            .setExpiration(Date(System.currentTimeMillis() + securityProperties.accessExp * 1000))
            .compact()
}