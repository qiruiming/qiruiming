package com.qrm.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> {

    private Integer code;

    private String message;

    private T data;

    public static final int SUCCESS_CODE = 200;

    public static final String SUCCESS_MESSAGE = "Suceess!";

    public static final int FAILED_CODE = 500;

    public static final String FAILED_MESSAGE = "系统异常,请联系管理员！";

    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<>(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static <T> ResultVO<T> failed() {
        return failed(FAILED_MESSAGE);
    }


    public static <T> ResultVO<T> failed(String message) {
        return failed(FAILED_CODE,message);
    }


    public static <T> ResultVO<T> failed(int code,String message) {
        return new ResultVO<>(code, message, null);
    }
}
