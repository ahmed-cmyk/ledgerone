package com.example.ledgerone.repository

import com.example.ledgerone.entity.Budget
import org.springframework.data.jpa.repository.JpaRepository

interface BudgetRepository: JpaRepository<Budget, Long> {
}