package org.megatouch.api.controller;

import jakarta.validation.Valid;
import org.megatouch.api.dto.inflatable.request.InflatableRequestDto;
import org.megatouch.api.entity.Inflatable;
import org.megatouch.api.service.InflatableService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inflatable")
public class InflatableController {

    private final InflatableService inflatableService;

    public InflatableController(InflatableService inflatableService) {
        this.inflatableService = inflatableService;
    }

    @GetMapping
    public Page<Inflatable> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
     return inflatableService.findAll(page, size);
    }

    @PostMapping
    public Inflatable saveInflatable(@RequestBody @Valid InflatableRequestDto dto) {
        return inflatableService.saveInflatable(dto);
    }

    @GetMapping("/{id}")
    public Inflatable getInflatable(@PathVariable Long id) {
        return inflatableService.getInflatable(id);
    }

    @PutMapping("/{id}")
    public Inflatable updateInflatable(@PathVariable Long id, @RequestBody @Valid InflatableRequestDto dto) {
        return inflatableService.updateInflatable(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteInflatable(@PathVariable Long id) {
        inflatableService.deleteInflatable(id);
    }

}
