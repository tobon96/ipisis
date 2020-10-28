package com.ipisis.controllers;

import com.ipisis.constants.EndpointsConstants;
import com.ipisis.dtos.*;
import com.ipisis.models.responses.DetallePeticionResponse;
import com.ipisis.services.EquipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(EndpointsConstants.ENDPOINT_EQUIPOS)
@CrossOrigin
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping(value = EndpointsConstants.ENDPOINT_ID,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EquipoEstudianteDTO>> obtenerSemestres(@PathVariable int id){
        return new ResponseEntity<>(equipoService.obtenerEquipos(id), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EquipoDTO> crearEquipo(@Valid @RequestBody EquipoDTO equipoDTO) {
        return new ResponseEntity<>(equipoService.crearEquipo(equipoDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = EndpointsConstants.ENDPOINT_IDEAS_ESTADO, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DetallePeticionResponse> cambiarEstadoInvitacionEquipo(@Valid @RequestBody EquipoInvitacionProcesamientoDTO invitacionProcesamientoDTO) {
        return new ResponseEntity<>(equipoService.procesarInvitacion(invitacionProcesamientoDTO), HttpStatus.ACCEPTED);
    }
}
