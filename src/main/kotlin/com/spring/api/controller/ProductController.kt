package com.spring.api.controller

import com.spring.api.model.CreateProductRequest
import com.spring.api.model.ProductResponse
import com.spring.api.model.WebResponse
import com.spring.api.service.ProductService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(val productService: ProductService) {

    @PostMapping(
        value =["/api/v1/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse>{
        val productResponse = productService.create(body);
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

}