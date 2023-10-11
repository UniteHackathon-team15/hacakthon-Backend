package com.hackathon.backend.domain.postDetails.presentation

import com.hackathon.backend.domain.postDetails.presentation.dto.request.CreatePostRequest
import com.hackathon.backend.domain.postDetails.service.CreatePostService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/posts")
@RestController
class PostDetailsController(
    private val createPostService: CreatePostService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createPost(@RequestBody request: CreatePostRequest) {
        createPostService.execute(request)
    }
}