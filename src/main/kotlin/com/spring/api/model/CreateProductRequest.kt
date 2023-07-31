package com.spring.api.model

data class CreateProductRequest (

    val name : String,

    val price : Long,

    val quantity : Int,
)