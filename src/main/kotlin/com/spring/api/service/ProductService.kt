package com.spring.api.service

import com.spring.api.entity.Products
import com.spring.api.model.CreateProductRequest
import com.spring.api.model.DeleteResponse
import com.spring.api.model.ProductResponse
import com.spring.api.model.UpdateProductRequest
import org.springframework.stereotype.Service
import java.util.UUID

@Service
interface ProductService {

    fun getProducts(): MutableList<Products>

    fun getProductId(id: UUID): Products?

    fun createProduct(createProductRequest: CreateProductRequest): ProductResponse

    fun updateProduct(updateProductRequest: UpdateProductRequest, id: UUID): ProductResponse?

    fun deleteProduct(id: UUID)

}