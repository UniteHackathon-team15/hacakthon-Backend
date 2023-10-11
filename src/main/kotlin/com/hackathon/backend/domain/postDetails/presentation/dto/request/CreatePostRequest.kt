package com.hackathon.backend.domain.postDetails.presentation.dto.request

import javax.validation.constraints.NotBlank

class CreatePostRequest(

    @field:NotBlank
    val title: String,

    @field:NotBlank
    val summary: String,

    val image: String,

    @field:NotBlank
    val postDetailsList: List<PostDetailsList>
)

data class PostDetailsList(
    val stageId: Long,
    val content: String,
    val firstOptionId: Long,
    val firstOptionContent: String,
    val secondOptionId: Long,
    val secondOptionContent: String,
    val thirdOptionId: Long,
    val thirdOptionContent: String
)