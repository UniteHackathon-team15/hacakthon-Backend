package com.hackathon.backend.domain.post.persistence

import org.springframework.data.repository.CrudRepository

interface PostRepository : CrudRepository<PostEntity, Long> {

}