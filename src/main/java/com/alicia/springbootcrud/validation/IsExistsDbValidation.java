package com.alicia.springbootcrud.validation;

import com.alicia.springbootcrud.service.IProductService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IsExistsDbValidation implements ConstraintValidator<IsExistsDb, String> {

    @Autowired
    private IProductService service;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(service == null) {
            return true;
        }
        return !service.existsBySku(value);
    }
}
