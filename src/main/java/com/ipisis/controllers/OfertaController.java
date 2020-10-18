package com.ipisis.controllers;

import com.ipisis.constants.EndpointsConstants;
import com.ipisis.dtos.IdeaDTO;
import com.ipisis.mappers.OfertaDTO;
import com.ipisis.models.responses.DetallePeticionResponse;
import com.ipisis.services.OfertaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(EndpointsConstants.ENDPOINT_OFERTAS)
@CrossOrigin
public class OfertaController {

    private final OfertaService ofertaService;

    public OfertaController(OfertaService ofertaService) {
        this.ofertaService = ofertaService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DetallePeticionResponse> crearOfertas(@Valid @RequestBody OfertaDTO ofertaDTO) {
        return new ResponseEntity<>(ofertaService.crearOfertas(ofertaDTO), HttpStatus.CREATED);
    }
}
