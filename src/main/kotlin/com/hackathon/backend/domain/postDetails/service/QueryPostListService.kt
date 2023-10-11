package com.hackathon.backend.domain.postDetails.service

import com.hackathon.backend.domain.post.persistence.PostRepository
import com.hackathon.backend.domain.postDetails.presentation.dto.response.PostList
import com.hackathon.backend.domain.postDetails.presentation.dto.response.QueryPostListResponse
import org.springframework.stereotype.Service

@Service
class QueryPostListService(
    private val postRepository: PostRepository
) {

    fun execute(): QueryPostListResponse {
        val postList = postRepository.findAll()

        return QueryPostListResponse(
            postList = postList.map {
                PostList(
                    title = it.title,
                    summary = it.summary,
                    image = it.image
                )
            }
        )
    }
}