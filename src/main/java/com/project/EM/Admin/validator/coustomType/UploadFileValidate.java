package com.project.EM.Admin.validator.coustomType;

import com.project.EM.Admin.validator.validation.UploadFileCheck;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UploadFileCheck.class})
public @interface UploadFileValidate {

    String message() default "photo is required";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
