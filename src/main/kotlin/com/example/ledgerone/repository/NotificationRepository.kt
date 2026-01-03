package com.example.ledgerone.repository

import com.example.ledgerone.entity.Notification
import org.springframework.data.jpa.repository.JpaRepository

interface NotificationRepository: JpaRepository<Notification, Long> {
}