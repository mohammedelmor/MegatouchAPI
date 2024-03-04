package org.megatouch.api.config;

import org.megatouch.api.entity.Inflatable;
import org.megatouch.api.entity.InflatableCategory;
import org.megatouch.api.repository.InflatableCategoryRepository;
import org.megatouch.api.repository.InflatableRepository;
import org.megatouch.api.service.InflatableCategoryService;
import org.megatouch.api.service.InflatableService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("test-data")

public class DataLoader {

    private final InflatableRepository inflatableRepository;
    private final InflatableCategoryRepository inflatableCategoryRepository;

    public DataLoader(InflatableRepository inflatableRepository, InflatableCategoryRepository inflatableCategoryRepository) {
        this.inflatableRepository = inflatableRepository;
        this.inflatableCategoryRepository = inflatableCategoryRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadData() {

        inflatableCategoryRepository.deleteAll();
        inflatableRepository.deleteAll();

        var inflatableCategory1 = new InflatableCategory();
        inflatableCategory1.setEnName("Category 1");
        inflatableCategory1.setArName("Category 1");

        var inflatableCategory2 = new InflatableCategory();
        inflatableCategory2.setEnName("Category 2");
        inflatableCategory2.setArName("Category 2");

        inflatableCategoryRepository.saveAll(List.of(inflatableCategory1, inflatableCategory2));

        var inflatable1 = new Inflatable();
        inflatable1.setEnName("Inflatable 1");
        inflatable1.setArName("Inflatable 1");
        inflatable1.setEnDescription("Inflatable 1");
        inflatable1.setArDescription("Inflatable 1");
        inflatable1.setLength(1);
        inflatable1.setWidth(1);
        inflatable1.setHeight(1);
        inflatable1.setCategory(inflatableCategory1);
        inflatable1.setImages(List.of("image1", "image2"));
        inflatable1.setKeywords(List.of("keyword1", "keyword2"));

        var inflatable2 = new Inflatable();
        inflatable2.setEnName("Inflatable 2");
        inflatable2.setArName("Inflatable 2");
        inflatable2.setEnDescription("Inflatable 2");
        inflatable2.setArDescription("Inflatable 2");
        inflatable2.setLength(2);
        inflatable2.setWidth(2);
        inflatable2.setHeight(2);
        inflatable2.setCategory(inflatableCategory2);
        inflatable2.setImages(List.of("image3", "image4"));
        inflatable2.setKeywords(List.of("keyword3", "keyword4"));

        inflatableRepository.saveAll(List.of(inflatable1, inflatable2));
    }

}
