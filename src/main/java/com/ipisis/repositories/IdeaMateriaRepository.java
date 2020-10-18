package com.ipisis.repositories;

import com.ipisis.models.entities.tables.IdeaMateria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaMateriaRepository extends CrudRepository<IdeaMateria, Integer> {
}
