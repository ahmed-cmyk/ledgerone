package com.example.ledgerone.repository

import com.example.ledgerone.entity.Tenant
import com.example.ledgerone.entity.TenantUser
import org.springframework.data.jpa.repository.JpaRepository

interface TenantUserRepository: JpaRepository<Tenant, Long> {

    fun existsByTenantIdAndUserId(tenantId: Long, userId: Long): Boolean

    fun findAllByTenantId(tenantId: Long): List<TenantUser>

    fun findAllByUserId(userId: Long): List<TenantUser>
}