package com.ipisis.controllers;

import com.ipisis.constants.EndpointsConstants;
import com.ipisis.dtos.MateriaDTO;
import com.ipisis.services.MateriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EndpointsConstants.ENDPOINT_MATERIAS)
@CrossOrigin
public class MateriaController {

    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MateriaDTO>> obtenerIdeas(){
        return new ResponseEntity<>(materiaService.obtenerMaterias(), HttpStatus.OK);
    }

    @GetMapping(value = EndpointsConstants.ENDPOINT_MATERIAS_CURSOS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MateriaDTO>> obtenerCursos(){
        return new ResponseEntity<>(materiaService.obtenerListaCursos(), HttpStatus.OK);
    }

    @GetMapping(value = EndpointsConstants.ENDPOINT_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MateriaDTO> obtenerIdea(@PathVariable int id){
        return new ResponseEntity<>(materiaService.obtenerMateria(id), HttpStatus.OK);
    }
}
