package com.ipisis.repositories;

import com.ipisis.models.entities.views.MateriaIdeaView;
import com.ipisis.models.entities.views.MateriaIdeaViewCompositeKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MateriaIdeaRepository extends CrudRepository<MateriaIdeaView, MateriaIdeaViewCompositeKey> {

    @Override
    ArrayList<MateriaIdeaView> findAll();
}
