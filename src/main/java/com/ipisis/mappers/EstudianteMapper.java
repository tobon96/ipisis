package com.ipisis.mappers;

import com.ipisis.dtos.EstudianteDTO;
import com.ipisis.models.entities.tables.Estudiante;

public class EstudianteMapper {

    public static EstudianteDTO mapearEstudiante(Estudiante estudiante) {
         return EstudianteDTO.builder()
                 .id(estudiante.getId())
                 .identificacion(estudiante.getDni())
                 .usuario(estudiante.getUsuario())
                 .nombre(estudiante.getNombre())
                 .correo(estudiante.getCorreo())
                 .build();
    }
}
