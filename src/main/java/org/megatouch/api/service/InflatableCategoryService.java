package org.megatouch.api.service;

import org.megatouch.api.dto.inflatableCategory.request.InflatableCategoryDto;
import org.megatouch.api.entity.InflatableCategory;
import org.megatouch.api.exception.InflatableCategoryNotFoundException;
import org.megatouch.api.repository.InflatableCategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class InflatableCategoryService {
    private final InflatableCategoryRepository inflatableCategoryRepository;

    public InflatableCategoryService(InflatableCategoryRepository inflatableCategoryRepository) {
        this.inflatableCategoryRepository = inflatableCategoryRepository;
    }

    public Page<InflatableCategory> findAll(int page, int size) {
        return inflatableCategoryRepository.findAll(PageRequest.of(page, size, Sort.by("id").ascending()));
    }

    public InflatableCategory getInflatableCategory(Long id) {
        return inflatableCategoryRepository.findById(id).orElseThrow(() -> new InflatableCategoryNotFoundException(id));
    }

    public InflatableCategory saveInflatableCategory(InflatableCategoryDto dto) {
        if (exists(dto)) {
            throw new IllegalArgumentException("Inflatable category already exists");
        }
        return inflatableCategoryRepository.save(dto.toEntity());
    }

    public InflatableCategory updateInflatableCategory(Long id, InflatableCategoryDto dto) {
        var entity = inflatableCategoryRepository.findById(id);
        entity.map(inflatableCategory -> {
            inflatableCategory.setEnName(dto.enName());
            inflatableCategory.setArName(dto.arName());
            return inflatableCategoryRepository.save(inflatableCategory);
        }).orElseThrow(() -> new InflatableCategoryNotFoundException(id));
        return entity.get();
    }

    public void deleteInflatableCategory(Long id) {
        if (!inflatableCategoryRepository.existsById(id)) {
            throw new InflatableCategoryNotFoundException(id);
        }
        inflatableCategoryRepository.deleteById(id);
    }

    public boolean exists(InflatableCategoryDto dto) {
        return inflatableCategoryRepository.existsByEnName(dto.enName()) || inflatableCategoryRepository.existsByArName(dto.arName());
    }

}
