package com.project.EM.Master.DTO;

import com.project.EM.Master.Entity.DepartmentEntity;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class MasterDataAPIResponce <T>{

    private String msg;
    private Boolean status;
    private List<T> data;

    public MasterDataAPIResponce(boolean status, String msg, T data) {
        this.msg=msg;
        this.status=status;
        this.data= Collections.singletonList(data);
    }

}
