package com.qrm.system.advice;


import com.qrm.exception.ParamException;
import com.qrm.system.entity.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ParamException.class)
    public ResultVO handle(ParamException e) {
        log.error(e.getMessage(), e);
        return ResultVO.failed(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultVO handle(Exception e) {
        log.error(e.getMessage(), e);
        return ResultVO.failed();
    }
}
