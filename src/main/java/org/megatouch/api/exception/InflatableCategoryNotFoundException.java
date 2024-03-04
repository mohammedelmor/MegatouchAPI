package org.megatouch.api.exception;

public class InflatableCategoryNotFoundException extends RuntimeException {
    public InflatableCategoryNotFoundException(Long id) {
        super("The category with id " + id + " does not exist.");
    }
}
