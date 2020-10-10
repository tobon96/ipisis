package com.ipisis.repositories;

import com.ipisis.models.entities.tables.Idea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Integer> {

    @Override
    HashSet<Idea> findAll();
}
