package org.megatouch.api.dto.inflatableCategory.request;

import jakarta.validation.constraints.NotEmpty;
import org.megatouch.api.entity.InflatableCategory;

import java.io.Serializable;

/**
 * DTO for {@link org.megatouch.api.entity.InflatableCategory}
 */
public record InflatableCategoryDto(@NotEmpty(message = "English Name Can't be empty") String enName,
                                    @NotEmpty(message = "Arabic Name Can't be empty") String arName) implements Serializable {
    public InflatableCategory toEntity() {
        var entity =  new InflatableCategory();
        entity.setEnName(enName);
        entity.setArName(arName);
        return entity;
    }
}