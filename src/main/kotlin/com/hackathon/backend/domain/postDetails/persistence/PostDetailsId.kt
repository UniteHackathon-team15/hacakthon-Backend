package com.hackathon.backend.domain.postDetails.persistence

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class PostDetailsId(

    @Column(nullable = false)
    val post: Long,

    @Column(name = "post_details_id", nullable = false)
    val postDetails: Long

) : Serializable