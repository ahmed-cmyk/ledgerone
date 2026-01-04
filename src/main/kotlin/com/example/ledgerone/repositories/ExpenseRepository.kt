package com.example.ledgerone.repositories

import com.example.ledgerone.entities.Expense
import org.springframework.data.jpa.repository.JpaRepository

interface ExpenseRepository: JpaRepository<Expense, Long> {
}