package com.example.ledgerone.repositories

import com.example.ledgerone.entities.Budget
import org.springframework.data.jpa.repository.JpaRepository

interface BudgetRepository: JpaRepository<Budget, Long> {
}