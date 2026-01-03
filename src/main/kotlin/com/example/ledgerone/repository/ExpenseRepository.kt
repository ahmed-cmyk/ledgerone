package com.example.ledgerone.repository

import com.example.ledgerone.entity.Expense
import org.springframework.data.jpa.repository.JpaRepository

interface ExpenseRepository: JpaRepository<Expense, Long> {
}