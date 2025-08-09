package com.project.EM.Admin.validator.coustomType;

import com.project.EM.Admin.validator.validation.NameValidate;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {NameValidate.class}
)
public @interface EmployeNameValidate {

    String message() default "Name can not be null";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
