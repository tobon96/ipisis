package com.ipisis.mappers;

import com.ipisis.dtos.SemestreDTO;
import com.ipisis.models.entities.tables.Semestre;
import com.ipisis.utils.DateUtils;

public class SemestreDTOMapper {

    public static SemestreDTO mapearSemestre(Semestre semestre) {

        return SemestreDTO.builder()
                .codigo(semestre.getCodigo())
                .inicioSemestre(DateUtils.df.format(semestre.getInicioSemestre()))
                .cierreSemestre(DateUtils.df.format(semestre.getCierreSemestre()))
                .inicioInscripcion(DateUtils.df.format(semestre.getInicioInscripcion()))
                .cierreInscripcion(DateUtils.df.format(semestre.getCierreInscripcion()))
                .build();
    }
}
