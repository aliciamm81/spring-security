package com.alicia.springbootcrud.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class RequieredValidation implements ConstraintValidator<IsRequired, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //return value != null && !value.isEmpty() && !value.isBlank();
        return StringUtils.hasText(value);
    }
}
