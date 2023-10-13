package com.hackathon.backend.global.error

import com.hackathon.backend.global.error.response.BaseErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(BindException::class)
    fun handleBindException(e: BindException): ResponseEntity<*>? {
        val errorMap = HashMap<String, String?>()

        for (error: FieldError in e.fieldErrors) {
            errorMap[error.field] = error.defaultMessage
        }
        return ResponseEntity<Map<String, String?>>(errorMap, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(CustomException::class)
    fun handleCustomException(e: CustomException): ResponseEntity<BaseErrorResponse> {
        return ResponseEntity(
            BaseErrorResponse.of(e),
            HttpStatus.valueOf(e.status)
        )
    }
}