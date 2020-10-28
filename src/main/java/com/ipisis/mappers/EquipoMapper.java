package com.ipisis.mappers;

import com.ipisis.dtos.EquipoEstudianteDTO;
import com.ipisis.models.entities.tables.EquipoEstudiante;
import com.ipisis.utils.DateUtils;

public class EquipoMapper {

    public static EquipoEstudianteDTO mapearEquipoEstudiante(EquipoEstudiante equipoEstudiante) {
        return EquipoEstudianteDTO.builder()
                .idEquipo(equipoEstudiante.getIdEquipo())
                .nombreEquipo(equipoEstudiante.getEquipo().getNombre())
                .idEstudiante(equipoEstudiante.getIdEstudiante())
                .fechaCreacion(DateUtils.df.format(equipoEstudiante.getEquipo().getFechaCreacion()))
                .estadoInvitacion(equipoEstudiante.getEstadoInvitacion())
                .estadoActa(equipoEstudiante.getEstadoActa())
                .build();
    }
}
