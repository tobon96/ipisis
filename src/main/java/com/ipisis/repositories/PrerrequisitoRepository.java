package com.ipisis.repositories;

import com.ipisis.models.entities.tables.Prerrequisito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrerrequisitoRepository extends CrudRepository<Prerrequisito, Integer> {
}
