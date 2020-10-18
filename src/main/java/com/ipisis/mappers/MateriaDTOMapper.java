package com.ipisis.mappers;

import com.ipisis.dtos.MateriaDTO;
import com.ipisis.models.entities.tables.Materia;

public class MateriaDTOMapper {

    public static MateriaDTO mapearMateria(Materia materia) {
        return MateriaDTO.builder()
                .codigo(materia.getId())
                .materia(materia.getNombre())
                .build();
    }
}
