package com.hackathon.backend.domain.postDetails.service

import com.hackathon.backend.domain.postDetails.exception.PostDetailsNotFoundException
import com.hackathon.backend.domain.postDetails.persistence.PostDetailsId
import com.hackathon.backend.domain.postDetails.persistence.PostDetailsRepository
import com.hackathon.backend.domain.postDetails.presentation.dto.response.QueryPostDetailsResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class QueryPostDetailsService(
    private val postDetailsRepository: PostDetailsRepository
) {

    fun execute(postId: Long, postDetailsId: Long): QueryPostDetailsResponse {

        val postDetails = postDetailsRepository.findByIdOrNull(PostDetailsId(postId, postDetailsId))
            ?: throw PostDetailsNotFoundException

        return QueryPostDetailsResponse(
            content = postDetails.content,
            firstOptionId = postDetails.firstOptionId,
            firstOptionContent = postDetails.firstOptionContent,
            secondOptionId = postDetails.secondOptionId,
            secondOptionContent = postDetails.secondOptionContent,
            thirdOptionId = postDetails.thirdOptionId,
            thirdOptionContent = postDetails.thirdOptionContent
        )
    }
}