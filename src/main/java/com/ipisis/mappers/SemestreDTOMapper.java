package com.ipisis.mappers;

import com.ipisis.constants.MapeosConstants;
import com.ipisis.dtos.SemestreDTO;
import com.ipisis.models.entities.tables.Semestre;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SemestreDTOMapper {

    public static final DateFormat df = new SimpleDateFormat(MapeosConstants.DATE_FORMAT);

    public static SemestreDTO mapearSemestre(Semestre semestre) {

        return SemestreDTO.builder()
                .codigo(semestre.getCodigo())
                .inicioSemestre(df.format(semestre.getInicioSemestre()))
                .cierreSemestre(df.format(semestre.getCierreSemestre()))
                .inicioInscripcion(df.format(semestre.getInicioInscripcion()))
                .cierreInscripcion(df.format(semestre.getCierreInscripcion()))
                .build();
    }
}
