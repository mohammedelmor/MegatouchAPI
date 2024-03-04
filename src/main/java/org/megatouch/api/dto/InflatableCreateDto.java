package org.megatouch.api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link org.megatouch.api.entity.Inflatable}
 */
public record InflatableCreateDto(@NotEmpty(message = "English name can't be empty") String enName,
                                  @NotEmpty(message = "Arabic name can't be empty") String arName,
                                  @NotEmpty(message = "English description can't be empty") String enDescription,
                                  @NotEmpty(message = "Arabic description can't be empty") String arDescription,
                                  @NotNull(message = "Length can't be null") @Positive(message = "Length must be positive") Integer length,
                                  @NotNull(message = "Width can't be null") @Positive(message = "Width must be positive") Integer width,
                                  @NotNull(message = "Height can't be null") @Positive(message = "Height must be positive") Integer height,
                                  @NotNull(message = "Category ID can't be null") Long category_id,
                                  @NotEmpty(message = "Images can't be empty") List<String> images,
                                  @NotEmpty(message = "Keywords can't be empty") List<String> keywords) implements Serializable {
}