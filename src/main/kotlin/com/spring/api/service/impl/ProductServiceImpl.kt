package com.spring.api.service.impl

import com.spring.api.entity.Products
import com.spring.api.model.CreateProductRequest
import com.spring.api.model.DeleteResponse
import com.spring.api.model.ProductResponse
import com.spring.api.model.UpdateProductRequest
import com.spring.api.repository.ProductRepository
import com.spring.api.service.ProductService
import org.springframework.stereotype.Service
import java.util.Date
import java.util.UUID

@Service
class ProductServiceImpl(val productRepository: ProductRepository): ProductService {
    override fun getProducts(): MutableList<Products> {
        return productRepository.findAll();
    }

    override fun getProductId(id: UUID): Products {
        return productRepository.findById(id).orElse(null);
    }

    override fun createProduct(createProductRequest: CreateProductRequest): ProductResponse {
        val product = Products(
            id = UUID.randomUUID(),
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

    override fun updateProduct(updateProductRequest: UpdateProductRequest, id: UUID): ProductResponse? {
        val existingProduct = productRepository.findById(id).orElse(null)
        if (existingProduct != null) {
            val product = existingProduct
            product.name = updateProductRequest.name ?:existingProduct.name
            product.price = updateProductRequest.price ?: existingProduct.price
            product.quantity = updateProductRequest.quantity ?: existingProduct.quantity
            product.updatedAt = Date()

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
        return null;
    }

    override fun deleteProduct(id: UUID) {
        return productRepository.deleteById(id)
    }

}