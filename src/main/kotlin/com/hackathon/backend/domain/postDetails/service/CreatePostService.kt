package com.hackathon.backend.domain.postDetails.service

import com.hackathon.backend.domain.post.persistence.PostEntity
import com.hackathon.backend.domain.post.persistence.PostRepository
import com.hackathon.backend.domain.postDetails.persistence.PostDetailsEntity
import com.hackathon.backend.domain.postDetails.persistence.PostDetailsId
import com.hackathon.backend.domain.postDetails.persistence.PostDetailsRepository
import com.hackathon.backend.domain.postDetails.presentation.dto.request.CreatePostRequest
import com.hackathon.backend.domain.user.exception.UserNotFoundException
import com.hackathon.backend.domain.user.persistence.UserRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class CreatePostService(
    private val userRepository: UserRepository,
    private val postRepository: PostRepository,
    private val postDetailsRepository: PostDetailsRepository,
) {

    fun execute(request: CreatePostRequest) {

        val accountId = SecurityContextHolder.getContext().authentication.name

        val user = userRepository.findByAccountId(accountId)
            ?: throw UserNotFoundException

        val post = postRepository.save(
            PostEntity(
                title = request.title,
                summary = request.summary,
                image = request.image,
                userEntity = user
            )
        )

        val postDetailsList = request.postDetailsList
            .map {
                PostDetailsEntity(
                    id = PostDetailsId(post.id, it.stageId),
                    postEntity = post,
                    content = it.content,
                    firstOptionId = it.firstOptionId,
                    firstOptionContent = it.firstOptionContent,
                    secondOptionId = it.secondOptionId,
                    secondOptionContent = it.secondOptionContent,
                    thirdOptionId = it.thirdOptionId,
                    thirdOptionContent = it.thirdOptionContent
                )
            }

        postDetailsRepository.saveAll(postDetailsList)
    }
}