package com.ipisis.controllers;

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


    @Test
    public void probarRepository() {
        ideaService.obtenerIdea(1);
    }
}
