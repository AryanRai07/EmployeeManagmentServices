package com.project.EM.Admin.validator.validation;

import com.project.EM.Admin.validator.coustomType.UploadFileValidate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class UploadFileCheck implements ConstraintValidator<UploadFileValidate, MultipartFile> {

    public static Integer MAX_SIZE = 1024*1024*1;
    @Override
    public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
        if(value==null|| value.isEmpty()){

            return false;
        } else if (value.getContentType() == null || value.getContentType().isEmpty() ||
                (!value.getContentType().equals("image/png") && !value.getContentType().equals("image/jpeg"))) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Only PNG and JPEG files are allowed")
                    .addConstraintViolation();
            return false;
        } else if (value.getSize()>MAX_SIZE) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Photo Size can not be more than 1MB")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
