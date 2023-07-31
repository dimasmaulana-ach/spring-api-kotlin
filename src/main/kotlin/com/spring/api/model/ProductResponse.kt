package com.spring.api.model

import java.util.*

data class ProductResponse(

    val id: UUID,

    val name: String,

    val price: Long,

    val quantity: Int,

    val createdAt: Date,

    val updatedAt: Date?
)