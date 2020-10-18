package com.ipisis.controllers;

import com.ipisis.models.entities.tables.IdeaMateria;
import com.ipisis.repositories.IdeaMateriaRepository;
import com.ipisis.services.IdeaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IdeaControllerTest {

    //IdeaRepository ideaRepository;

    @Autowired
    IdeaService ideaService;

    @Autowired
    IdeaMateriaRepository ideaMateriaRepository;


    @Test
    public void probarRepository() {

        IdeaMateria ideaMateria = new IdeaMateria();

        ideaMateria.setIdeaId(128);
        ideaMateria.setMateriaId(2508103);

        ideaMateria = ideaMateriaRepository.save(ideaMateria);

    }
}
