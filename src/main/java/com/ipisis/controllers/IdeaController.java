package com.ipisis.controllers;

import com.ipisis.constants.EndpointsConstants;
import com.ipisis.dtos.IdeaDTO;
import com.ipisis.services.IdeaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(EndpointsConstants.ENDPOINT_IDEAS)
@CrossOrigin
public class IdeaController {

    private final IdeaService ideaService;

    public IdeaController(IdeaService ideaService) {
        this.ideaService = ideaService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<IdeaDTO>> obtenerIdeas(){
        return new ResponseEntity<>(ideaService.obtenerIdeas(), HttpStatus.OK);
    }

    @GetMapping(value = EndpointsConstants.ENDPOINT_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IdeaDTO> obtenerIdea(@PathVariable int id) {
        return new ResponseEntity<>(ideaService.obtenerIdea(id), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IdeaDTO> crearIdea(@Valid @RequestBody IdeaDTO ideaDTO) {
        return new ResponseEntity<>(ideaService.crearIdea(ideaDTO), HttpStatus.CREATED);
    }
}
