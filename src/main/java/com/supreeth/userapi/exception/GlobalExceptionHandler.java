package com.supreeth.userapi.exception;

import com.supreeth.userapi.dto.ErrorDto;
import com.supreeth.userapi.helper.ErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity handleServerExceptions(Exception ex, WebRequest request)
    {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorCode(ErrorCode.SRV_ERROR_SERVER_DOWN.getError_code());
        errorDto.setErrorMessage(ErrorCode.SRV_ERROR_SERVER_DOWN.getError_message());
        return new ResponseEntity<ErrorDto>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity handleClientExceptions(Exception ex, HttpServletResponse response)
    {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorCode(ErrorCode.SRV_CLIENT_SERVER_DOWN.getError_code());
        errorDto.setErrorMessage(ErrorCode.SRV_CLIENT_SERVER_DOWN.getError_message());
        return new ResponseEntity<ErrorDto>(errorDto, HttpStatus.BAD_REQUEST);
    }
}
