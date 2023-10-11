package com.hackathon.backend.global.filter

import com.hackathon.backend.global.error.CustomException
import com.hackathon.backend.global.error.response.BaseErrorResponse
import com.hackathon.backend.global.exception.InternalServerError
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionFilter (
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            e.printStackTrace()
            when (e) {
                is CustomException -> setErrorMessage(e, response)
                else -> setErrorMessage(InternalServerError, response)
            }
        }
    }

    private fun setErrorMessage(e: CustomException, response: HttpServletResponse) {
        val errorResponse = BaseErrorResponse.of(e)

        response.characterEncoding = StandardCharsets.UTF_8.toString()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.status = errorResponse.status
        response.writer.write(objectMapper.writeValueAsString(errorResponse))
    }
}