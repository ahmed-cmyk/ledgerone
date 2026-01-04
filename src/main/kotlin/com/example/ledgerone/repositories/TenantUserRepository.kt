package com.example.ledgerone.repositories

import com.example.ledgerone.entities.Tenant
import com.example.ledgerone.entities.TenantUser
import org.springframework.data.jpa.repository.JpaRepository

interface TenantUserRepository: JpaRepository<Tenant, Long> {

    fun existsByTenantIdAndUserId(tenantId: Long, userId: Long): Boolean

    fun findAllByTenantId(tenantId: Long): List<TenantUser>

    fun findAllByUserId(userId: Long): List<TenantUser>
}