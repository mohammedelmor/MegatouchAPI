package org.megatouch.api.exception;

public class InflatableAlreadyExistsException extends RuntimeException {
    public InflatableAlreadyExistsException(String enName, String arName) {
        super("Inflatable with English name " + enName + " or Arabic name " + arName + " already exists");
    }
}
