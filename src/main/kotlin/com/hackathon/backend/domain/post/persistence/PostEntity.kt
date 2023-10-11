package com.hackathon.backend.domain.post.persistence

import com.hackathon.backend.domain.user.persistence.UserEntity
import javax.persistence.*

@Entity
class PostEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,

    var title: String,

    var summary: String,

    var image: String,

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false)
//    val userEntity: UserEntity
)