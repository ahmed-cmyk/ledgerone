package com.example.ledgerone.repositories

import com.example.ledgerone.entities.Notification
import org.springframework.data.jpa.repository.JpaRepository

interface NotificationRepository: JpaRepository<Notification, Long> {
}