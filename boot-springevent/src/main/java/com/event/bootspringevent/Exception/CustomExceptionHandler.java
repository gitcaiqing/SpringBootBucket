package com.event.bootspringevent.Exception;


import com.event.bootspringevent.util.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    /**
     * 业务异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResultModel handleBusinessException(BusinessException e) {
        log.error(e.getMessage(), e);
        return new ResultModel(e.getCode(), e.getMessage());
    }
}
