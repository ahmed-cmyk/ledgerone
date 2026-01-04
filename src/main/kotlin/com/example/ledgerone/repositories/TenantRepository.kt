package com.example.ledgerone.repositories

import com.example.ledgerone.entities.Tenant
import org.springframework.data.jpa.repository.JpaRepository

interface TenantRepository: JpaRepository<Tenant, Long> {
}