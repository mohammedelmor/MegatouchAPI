package org.megatouch.api.advice;

import jakarta.servlet.http.HttpServletRequest;
import org.megatouch.api.controller.InflatableController;
import org.megatouch.api.exception.InflatableAlreadyExistsException;
import org.megatouch.api.exception.InflatableNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(assignableTypes = InflatableController.class)
public class InflatableControllerAdvice {

    @ExceptionHandler(InflatableNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ExceptionResponse inflatableNotFoundHandler(final InflatableNotFoundException exception,
                                                                 final HttpServletRequest request) {
        return new ExceptionResponse(exception.getMessage(), request.getRequestURI());
    }


    @ExceptionHandler(InflatableAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody ExceptionResponse inflatableAlreadyExistsHandler(final InflatableAlreadyExistsException exception,
                                                                        final HttpServletRequest request) {
        return new ExceptionResponse(exception.getMessage(), request.getRequestURI());
    }

}
