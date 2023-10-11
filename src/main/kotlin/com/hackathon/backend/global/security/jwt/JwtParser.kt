package com.hackathon.backend.global.security.jwt

import com.hackathon.backend.global.exception.ExpiredTokenException
import com.hackathon.backend.global.exception.InternalServerError
import com.hackathon.backend.global.exception.InvalidTokenException
import com.hackathon.backend.global.security.SecurityProperties
import com.hackathon.backend.global.security.principle.CustomDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.InvalidClaimException
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class JwtParser (
    private val securityProperties: SecurityProperties,
    private val customDetailsService: CustomDetailsService
) {
    private fun getClaims(token: String): Claims {
        return try {
            Jwts.parser()
                .setSigningKey(securityProperties.secretKey)
                .parseClaimsJws(token)
                .body
        } catch (e: Exception) {
            when(e) {
                is InvalidClaimException -> throw InvalidTokenException
                is ExpiredJwtException -> throw ExpiredTokenException
                else -> throw InternalServerError
            }
        }
    }

    fun getAuthentication(token: String): Authentication {
        val claims = getClaims(token)
        val accountId = claims.subject
        val authDetails = customDetailsService.loadUserByUsername(accountId)

        return UsernamePasswordAuthenticationToken(authDetails, "", authDetails.authorities)
    }
}