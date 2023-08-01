package com.spring.api.validation

import jakarta.validation.ConstraintViolationException
import org.springframework.stereotype.Component
import javax.xml.transform.Source
import jakarta.validation.Validator

@Component
class ValidationUtil(val validator: Validator) {

    fun validate(any: Any){
        val result = validator.validate(any)
        if (result.size != 0){
            throw ConstraintViolationException(result)
        }
    }

}