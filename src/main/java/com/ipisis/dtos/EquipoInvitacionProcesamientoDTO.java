package com.ipisis.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipoInvitacionProcesamientoDTO {

    @NotNull(message = "El estado de la invitación no puede ser null")
    @NotEmpty(message = "El estado de la invitación no puede ser vacío")
    private String estado;

    @NotNull(message = "El id del equipo no puede ser null")
    private Integer idEquipo;

    @NotNull(message = "El id del estudiante no puede ser null")
    private int idEstudiante;
}
