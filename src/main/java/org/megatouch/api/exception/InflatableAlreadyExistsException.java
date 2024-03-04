package org.megatouch.api.exception;

public class InflatableAlreadyExistsException extends RuntimeException {
    public InflatableAlreadyExistsException(Long id) {
        super("The inflatable with id " + id + " already exists.");
    }
}
