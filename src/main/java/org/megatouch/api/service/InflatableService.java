package org.megatouch.api.service;

import org.megatouch.api.dto.inflatable.request.InflatableRequestDto;
import org.megatouch.api.entity.Inflatable;
import org.megatouch.api.exception.InflatableAlreadyExistsException;
import org.megatouch.api.exception.InflatableNotFoundException;
import org.megatouch.api.repository.InflatableRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InflatableService {

    private final InflatableRepository inflatableRepository;
    private final InflatableCategoryService inflatableCategoryService;

    public InflatableService(InflatableRepository inflatableRepository, InflatableCategoryService inflatableCategoryService) {
        this.inflatableRepository = inflatableRepository;
        this.inflatableCategoryService = inflatableCategoryService;
    }

    public Page<Inflatable> getInflatables(int page, int size) {
        return inflatableRepository.findAll(PageRequest.of(page, size, Sort.by("id").ascending()));
    }

    public Inflatable getInflatable(Long id) throws InflatableNotFoundException {
        return inflatableRepository.findById(id).orElseThrow(() -> new InflatableNotFoundException(id));
    }

    public Inflatable saveInflatable(InflatableRequestDto dto) {
        if (exists(dto)) {
            throw new InflatableAlreadyExistsException(dto.enName() , dto.arName());
        }
        Inflatable inflatable = new Inflatable();
        inflatable.setEnName(dto.enName());
        inflatable.setArName(dto.arName());
        inflatable.setEnDescription(dto.enDescription());
        inflatable.setArDescription(dto.arDescription());
        inflatable.setLength(dto.length());
        inflatable.setWidth(dto.width());
        inflatable.setHeight(dto.height());
        inflatable.setCategory(inflatableCategoryService.getInflatableCategory(dto.category_id()));
        inflatable.setImages(dto.images());
        inflatable.setKeywords(dto.keywords());
        return inflatableRepository.save(inflatable);
    }

    public Inflatable updateInflatable(Long id, InflatableRequestDto dto) {
        Optional<Inflatable> entity = inflatableRepository.findById(id);
        entity.map(inflatable -> {
            inflatable.setEnName(dto.enName());
            inflatable.setArName(dto.arName());
            inflatable.setEnDescription(dto.enDescription());
            inflatable.setArDescription(dto.arDescription());
            inflatable.setLength(dto.length());
            inflatable.setWidth(dto.width());
            inflatable.setHeight(dto.height());
            inflatable.setCategory(inflatableCategoryService.getInflatableCategory(dto.category_id()));
            inflatable.setImages(dto.images());
            inflatable.setKeywords(dto.keywords());
            return inflatableRepository.save(inflatable);
        }).orElseThrow(() -> new InflatableNotFoundException(id));
        return entity.get();
    }

    public void deleteInflatable(Long id) {
        if (!inflatableRepository.existsById(id)) {
            throw new InflatableNotFoundException(id);
        }
        inflatableRepository.deleteById(id);
    }

    public boolean exists(InflatableRequestDto inflatable) {
        return inflatableRepository.existsByEnName(inflatable.enName()) ||
                        inflatableRepository.existsByArName(inflatable.arName());
    }


}
