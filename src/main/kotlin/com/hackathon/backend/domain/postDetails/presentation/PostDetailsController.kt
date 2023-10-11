package com.hackathon.backend.domain.postDetails.presentation

import com.hackathon.backend.domain.postDetails.presentation.dto.request.CreatePostRequest
import com.hackathon.backend.domain.postDetails.presentation.dto.response.QueryPostDetailsResponse
import com.hackathon.backend.domain.postDetails.presentation.dto.response.QueryPostListResponse
import com.hackathon.backend.domain.postDetails.service.CreatePostService
import com.hackathon.backend.domain.postDetails.service.QueryPostDetailsService
import com.hackathon.backend.domain.postDetails.service.QueryPostListService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/posts")
@RestController
class PostDetailsController(
    private val createPostService: CreatePostService,
    private val queryPostListService: QueryPostListService,
    private val queryPostDetailsService: QueryPostDetailsService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createPost(@RequestBody request: CreatePostRequest) {
        createPostService.execute(request)
    }

    @GetMapping("/lists")
    fun queryPostList(): QueryPostListResponse =
        queryPostListService.execute()

    @GetMapping
    fun queryPostDetails(@RequestParam("post-id") postId: Long, @RequestParam("post-details-id") postDetailsId: Long): QueryPostDetailsResponse =
        queryPostDetailsService.execute(postId, postDetailsId)

}