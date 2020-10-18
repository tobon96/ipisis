package com.ipisis.controllers;

import com.ipisis.constants.EndpointsConstants;
import com.ipisis.dtos.SemestreDTO;
import com.ipisis.services.SemestreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(EndpointsConstants.ENDPOINT_SEMESTRES)
@CrossOrigin
public class SemestreController {

    private final SemestreService semestreService;

    public SemestreController(SemestreService semestreService) {
        this.semestreService = semestreService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SemestreDTO>> obtenerSemestres(){
        return new ResponseEntity<>(semestreService.obtenerSemestres(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SemestreDTO> crearSemestre(@Valid @RequestBody SemestreDTO semestreDTO) {
        return new ResponseEntity<>(semestreService.crearSemestre(semestreDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(EndpointsConstants.ENDPOINT_ID)
    public ResponseEntity<Void> eliminarSemestre(@PathVariable String id) {
        semestreService.eliminarSemestre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = EndpointsConstants.ENDPOINT_ID, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SemestreDTO> actualizarSemestre(@Valid @RequestBody SemestreDTO semestreDTO, @PathVariable String id) {
        return new ResponseEntity<>(semestreService.actualizarSemestre(semestreDTO, id), HttpStatus.ACCEPTED);
    }
}
