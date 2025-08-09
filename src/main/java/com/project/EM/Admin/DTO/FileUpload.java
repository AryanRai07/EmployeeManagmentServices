package com.project.EM.Admin.DTO;

import com.project.EM.Admin.validator.coustomType.UploadFileValidate;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileUpload {

    @UploadFileValidate
    private MultipartFile file;

}
