package com.ipisis.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdeaDTO {

    private int ideaId;
    private String titulo;
    private int grupos;
    private int integrantes;
    private IdeaMateriaDTO materias;

}
