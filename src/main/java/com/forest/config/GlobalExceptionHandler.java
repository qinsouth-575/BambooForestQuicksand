package com.forest.config;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthorizationException.class)
    public void authorizationException (HttpServletResponse response)  {
        try {
            response.sendRedirect("/unauth");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ExceptionHandler(Exception.class)
    public void handleException(Exception e,HttpServletResponse response){
        try {
            response.sendRedirect("/ourerror");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
