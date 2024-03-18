package com.alicia.springbootcrud.validation;

import com.alicia.springbootcrud.model.Product;
import jakarta.validation.ConstraintViolation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Set;

@Component
public class ProductValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        //Forma1
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name" , null, "es requerido!");
        //Forma2
        if(product.getDescription() == null || product.getDescription().isBlank()){
            errors.rejectValue("description","es requerido, por favor");
        }
        if(product.getPrice() == null){
            errors.rejectValue("price","No puede ser nulo");
        }else if(product.getPrice() < 500){
            errors.rejectValue("price","debe ser un valor mayor o igual que 500");
        }
    }
}
