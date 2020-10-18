package com.ipisis.controllers;

import com.ipisis.constants.EndpointsConstants;
import com.ipisis.dtos.ProfesorDTO;
import com.ipisis.services.ProfesorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(EndpointsConstants.ENDPOINT_PROFESORES)
@CrossOrigin
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProfesorDTO>> obtenerIdeas(){
        return new ResponseEntity<>(profesorService.obtenerProfesores(), HttpStatus.OK);
    }
}
