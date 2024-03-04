package org.megatouch.api.exception;

public class InflatableCategoryAlreadyExistsException extends RuntimeException {
    public InflatableCategoryAlreadyExistsException(String enName, String arName) {
        super("Category with English name " + enName + " or Arabic name " + arName + " already exists");
    }
}
