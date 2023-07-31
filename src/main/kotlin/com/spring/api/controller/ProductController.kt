package com.spring.api.controller

import com.spring.api.entity.Products
import com.spring.api.model.*
import com.spring.api.service.ProductService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class ProductController(val productService: ProductService) {

    @GetMapping(
        value = ["/api/v1/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun getProduct(): WebResponse<MutableList<Products>> {
        val productResponse = productService.getProducts();
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @GetMapping(
        value = ["/api/v1/products/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun getProductById(@PathVariable id: UUID): WebResponse<Products?> {
        val productResponse = productService.getProductId(id);
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @PostMapping(
        value =["/api/v1/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse>{
        val productResponse = productService.createProduct(body);
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @PutMapping(
        value =["/api/v1/products/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateProduct(@RequestBody body: UpdateProductRequest, @PathVariable id: UUID): WebResponse<ProductResponse?> {
        val productResponse = productService.updateProduct(body, id);
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @DeleteMapping(
        value =["/api/v1/products/{id}"]
    )
    fun deleteProduct(@PathVariable id: UUID): DeleteResponse {
        productService.deleteProduct(id);
        return DeleteResponse(
            code = 200,
            status = "OK",
            message = "Product deleted successfully"
        )
    }

}