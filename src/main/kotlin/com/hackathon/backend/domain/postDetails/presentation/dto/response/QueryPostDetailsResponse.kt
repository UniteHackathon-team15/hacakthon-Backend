package com.hackathon.backend.domain.postDetails.presentation.dto.response

class QueryPostDetailsResponse(
    val content: String,
    val firstOptionId: Long,
    val firstOptionContent: String,
    val secondOptionId: Long,
    val secondOptionContent: String,
    val thirdOptionId: Long,
    val thirdOptionContent: String
)