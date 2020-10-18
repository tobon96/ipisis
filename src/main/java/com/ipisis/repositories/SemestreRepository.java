package com.ipisis.repositories;

import com.ipisis.models.entities.tables.Semestre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SemestreRepository extends CrudRepository<Semestre, String> {

    @Override
    List<Semestre> findAll();
}
