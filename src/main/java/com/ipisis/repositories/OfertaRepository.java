package com.ipisis.repositories;

import com.ipisis.models.entities.tables.Oferta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfertaRepository extends CrudRepository<Oferta, Integer> {
}
