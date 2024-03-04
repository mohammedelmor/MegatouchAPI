package org.megatouch.api.repository;

import org.megatouch.api.entity.Inflatable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InflatableRepository extends JpaRepository<Inflatable, Long> {
    boolean existsByEnName(String enName);

    boolean existsByArName(String arName);
}
