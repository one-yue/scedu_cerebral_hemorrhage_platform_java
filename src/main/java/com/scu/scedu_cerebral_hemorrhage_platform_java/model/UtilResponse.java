package com.scu.scedu_cerebral_hemorrhage_platform_java.model;

import lombok.Data;

@Data
public class UtilResponse {

    public UtilResponse(Boolean isSuccess, String msg,Object body){
        this.isSuccess = isSuccess;
        this.msg = msg;
        this.body = body;
    }

    Boolean isSuccess;
    String msg;
    Object body;
}
