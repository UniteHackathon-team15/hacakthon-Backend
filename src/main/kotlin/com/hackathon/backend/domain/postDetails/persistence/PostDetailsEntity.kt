package com.hackathon.backend.domain.postDetails.persistence

import com.hackathon.backend.domain.post.persistence.PostEntity
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.MapsId

@Entity
class PostDetailsEntity(

    @EmbeddedId
    var id: PostDetailsId,

    @MapsId("post")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    var postEntity: PostEntity,

    var content: String,

    var firstOptionId: Long,

    var firstOptionContent: String,

    var secondOptionId: Long,

    var secondOptionContent: String,

    var thirdOptionId: Long,

    var thirdOptionContent: String,
)