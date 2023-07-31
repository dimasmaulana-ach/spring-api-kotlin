package com.spring.api.service.impl

import com.spring.api.entity.Products
import com.spring.api.model.CreateProductRequest
import com.spring.api.model.ProductResponse
import com.spring.api.repository.ProductRepository
import com.spring.api.service.ProductService
import org.springframework.stereotype.Service
import java.util.Date

@Service
class ProductServiceImpl(val productRepository: ProductRepository): ProductService {
    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        val product = Products(
            id = createProductRequest.id,
            name = createProductRequest.name,
            price = createProductRequest.price,
            quantity = createProductRequest.quantity,
            createdAt = Date(),
            updatedAt = null
        )

        productRepository.save(product)

        return ProductResponse(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt
        )
    }

}