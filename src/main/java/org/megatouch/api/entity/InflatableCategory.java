package org.megatouch.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class InflatableCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "inflatable_category_seq", sequenceName = "inflatable_category_seq", allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String enName;
    @Column(unique = true)
    private String arName;


}
