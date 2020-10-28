package com.ipisis.repositories;

import com.ipisis.models.entities.tables.Equipo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends CrudRepository<Equipo, Integer> {
}
