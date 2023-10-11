package com.hackathon.backend.domain.user.persistence

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserEntity, Long> {

    fun findByAccountId(accountId: String): UserEntity?

    fun existsByAccountId(accountId: String): Boolean
}