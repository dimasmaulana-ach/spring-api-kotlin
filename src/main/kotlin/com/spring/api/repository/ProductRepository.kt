package com.spring.api.repository

import com.spring.api.entity.Products
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Products, String> {
}