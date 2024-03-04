package org.megatouch.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
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

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private long createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private long modifiedDate;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "modified_by")
    @LastModifiedBy
    private String modifiedBy;
}