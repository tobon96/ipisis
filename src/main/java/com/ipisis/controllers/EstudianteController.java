package com.ipisis.controllers;

import com.ipisis.constants.EndpointsConstants;
import com.ipisis.dtos.EstudianteDTO;
import com.ipisis.services.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointsConstants.ENDPOINT_ESTUDIANTES)
@CrossOrigin
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping(value = EndpointsConstants.ENDPOINT_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstudianteDTO> obtenerEstudiante(@PathVariable int id) {
        return new ResponseEntity<>(estudianteService.obtenerEstudiante(id), HttpStatus.OK);
    }
}
