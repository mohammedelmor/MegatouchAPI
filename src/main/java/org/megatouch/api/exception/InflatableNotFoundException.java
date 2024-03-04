package org.megatouch.api.exception;

public class InflatableNotFoundException extends RuntimeException {
    public InflatableNotFoundException(Long id) {
        super("The inflatable with id " + id + " does not exist.");
    }
}
