package com.spring.api.repository

import com.spring.api.entity.Products
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ProductRepository : JpaRepository<Products, UUID> {
}