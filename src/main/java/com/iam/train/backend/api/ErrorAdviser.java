package com.iam.train.backend.api;

import com.iam.train.backend.Exception.BaseException;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorAdviser {
    /** กำหนดการแสดงผลในกรณีที่  Exception ในกรณีที่เกิด 500*/

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleException(BaseException e) {
        ErrorResponse response = new ErrorResponse();
        response.setError(e.getMessage());
        response.setStatus(HttpStatus.EXPECTATION_FAILED.value());
        return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
    }
@Data
    public static class ErrorResponse {
        private LocalDateTime dateTime = LocalDateTime.now();

        private int status;

        private String error;
    }
}
