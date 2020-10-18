package com.ipisis.repositories;

import com.ipisis.models.entities.tables.Profesor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor, Integer> {

    @Override
    List<Profesor> findAll();
}
