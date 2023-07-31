package com.spring.api.service

import com.spring.api.model.CreateProductRequest
import com.spring.api.model.ProductResponse

interface ProductService {

    fun create(createProductService: CreateProductRequest): ProductResponse

}