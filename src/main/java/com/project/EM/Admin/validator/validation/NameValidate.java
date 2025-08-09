package com.project.EM.Admin.validator.validation;

import com.project.EM.Admin.validator.coustomType.EmployeNameValidate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidate implements ConstraintValidator<EmployeNameValidate, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        if(value.length()<3){
                  context.disableDefaultConstraintViolation();
                  context.buildConstraintViolationWithTemplate("Name can not be less than 3 characters").addConstraintViolation();
                  return false;
        }
        return true;
    }
}
