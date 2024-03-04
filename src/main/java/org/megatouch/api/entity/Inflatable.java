package org.megatouch.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Inflatable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "inflatable_seq", sequenceName = "inflatable_seq", allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String enName;
    @Column(unique = true)
    private String arName;
    private String enDescription;
    private String arDescription;
    private Integer length;
    private Integer width;
    private Integer height;

    @OneToOne
    private InflatableCategory category;

    @ElementCollection
    @CollectionTable(name = "inflatable_images", joinColumns = @JoinColumn(name = "inflatable_id"))
    @Column(name = "image")
    private List<String> images;

    @ElementCollection
    @CollectionTable(name = "inflatable_keywords", joinColumns = @JoinColumn(name = "inflatable_id"))
    @Column(name = "keyword")
    private List<String> keywords;

}