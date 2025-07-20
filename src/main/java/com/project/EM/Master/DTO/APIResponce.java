package com.project.EM.Master.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class APIResponce<T> {
    private String msg;
    private Boolean status;
    private List<T> data;

    public APIResponce(boolean status, String msg, List<T> data) {
        this.msg=msg;
        this.status=status;
        this.data= data;
    }

    // Constructor to wrap a single object into a list
    public APIResponce(Boolean status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = (data != null) ? Collections.singletonList(data) : Collections.emptyList();
    }
}

