package com.ipisis.repositories;

import com.ipisis.models.entities.tables.IdeaHistorial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaHistorialRepository extends CrudRepository<IdeaHistorial, Integer> {
}
