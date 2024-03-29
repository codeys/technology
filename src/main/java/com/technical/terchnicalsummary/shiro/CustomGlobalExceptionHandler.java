package com.technical.terchnicalsummary.shiro;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CustomGlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(AuthorizationException.class)
    public String authorizationException() {
        return "unauthorized";
    }
}
