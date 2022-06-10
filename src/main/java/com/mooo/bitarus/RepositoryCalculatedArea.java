package com.mooo.bitarus;

import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RepositoryCalculatedArea extends JpaRepository<EntityCalculatedArea, Long> {
    List<EntityCalculatedArea> findByShapeType(String shapeType);

    EntityCalculatedArea findById(long id);
}
