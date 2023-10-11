package com.hackathon.backend.domain.postDetails.presentation.dto.response

class QueryPostListResponse(
   val postList: List<PostList>
)

data class PostList(
    val title: String,
    val summary: String,
    val image: String
)