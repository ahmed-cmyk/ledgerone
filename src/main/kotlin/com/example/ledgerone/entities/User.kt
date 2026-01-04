package com.example.ledgerone.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@Entity
@Table(name = "users", uniqueConstraints = [UniqueConstraint(columnNames = ["username", "email"])])
class User @OptIn(ExperimentalTime::class) constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "username", nullable = false)
    val username: String,

    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "password", nullable = false)
    val passwordHash: String,

    @Column(name = "created_at", nullable = false)
    val createdAt: Instant = Clock.System.now(),

    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant,
)
