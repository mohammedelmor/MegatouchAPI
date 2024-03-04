package org.megatouch.api.dto;

import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

/**
 * DTO for {@link org.megatouch.api.entity.InflatableCategory}
 */
public record InflatableCategoryCreateDto(@NotEmpty(message = "English Name Can't be empty") String enName,
                                          @NotEmpty(message = "Arabic Name Can't be empty") String arName) implements Serializable {
}