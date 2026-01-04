package com.example.ledgerone.repositories

import com.example.ledgerone.entities.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository: JpaRepository<Category, Long>