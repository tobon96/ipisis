package com.ipisis.mappers;

import com.ipisis.dtos.ProfesorDTO;
import com.ipisis.models.entities.tables.Profesor;

public class ProfesorDTOMapper {

    public static ProfesorDTO mapearProfesor(Profesor profesor) {
        return ProfesorDTO.builder()
                .usuario(profesor.getUsuario())
                .nombre(profesor.getNombre())
                .correo(profesor.getCorreo())
                .tipo(profesor.getTipo())
                .build();
    }
}
