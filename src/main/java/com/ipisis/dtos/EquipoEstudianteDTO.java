package com.ipisis.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipoEstudianteDTO {

    private Integer idEquipo;

    private String nombreEquipo;

    private String fechaCreacion;

    private Integer idEstudiante;

    private String estadoActa;

    private String estadoInvitacion;
}
