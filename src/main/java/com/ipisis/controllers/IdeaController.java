package com.ipisis.controllers;

import com.ipisis.constants.EndpointConstants;
import com.ipisis.dtos.IdeaDTO;
import com.ipisis.models.entities.tables.Idea;
import com.ipisis.services.IdeaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class IdeaController {

    private final IdeaService ideaService;

    public IdeaController(IdeaService ideaService) {
        this.ideaService = ideaService;
    }

    @GetMapping(value = EndpointConstants.ENDPOINT_BASE_IDEAS)
    public ResponseEntity<Idea> obtenerIdeas(){
        return new ResponseEntity<Idea>(new Idea(), HttpStatus.OK);
    }

    @GetMapping(value = EndpointConstants.ENDPOINT_ID_IDEAS)
    public ResponseEntity<IdeaDTO> obtenerIdea(@PathVariable int id) {
        return new ResponseEntity<IdeaDTO>(ideaService.obtenerIdea(id), HttpStatus.OK);
    }
}
