package com.example.ledgerone.repository

import com.example.ledgerone.entity.Tenant
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.UUID

interface TenantRepository: PagingAndSortingRepository<Tenant, UUID>, CrudRepository<Tenant, UUID> {
}