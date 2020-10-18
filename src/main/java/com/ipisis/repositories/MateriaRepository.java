package com.ipisis.repositories;

import com.ipisis.models.entities.tables.Materia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MateriaRepository extends CrudRepository<Materia, Integer> {

    @Override
    List<Materia> findAll();

    List<Materia> findAllByIdIn(Set<Integer> cursos);
}
