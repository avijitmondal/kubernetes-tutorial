package com.avijitmondal.tutorial.k8s.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GlobalNotFoundExceptionHandler extends RuntimeException {
    public GlobalNotFoundExceptionHandler() {
        super();
    }
    public GlobalNotFoundExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }
    public GlobalNotFoundExceptionHandler(String message) {
        super(message);
    }
    public GlobalNotFoundExceptionHandler(Throwable cause) {
        super(cause);
    }
}
