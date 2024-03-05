package org.megatouch.api.advice;

public record ExceptionResponse(String errorMessage, String requestedURI) { }