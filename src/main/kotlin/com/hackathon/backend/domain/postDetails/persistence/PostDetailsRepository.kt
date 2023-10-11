package com.hackathon.backend.domain.postDetails.persistence

import org.springframework.data.repository.CrudRepository

interface PostDetailsRepository : CrudRepository<PostDetailsEntity, PostDetailsId> {
}