package com.example.ledgerone.entity

import com.example.ledgerone.enum.TenantStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.ColumnDefault
import org.springframework.data.annotation.CreatedDate
import java.util.UUID
import java.time.Instant

@Entity
@Table(name = "tenants")
class Tenant(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    @Column(nullable = false)
    var name: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var status: TenantStatus = TenantStatus.ACTIVE,

    @CreatedDate
    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    var createdAt: Instant? = null,
)