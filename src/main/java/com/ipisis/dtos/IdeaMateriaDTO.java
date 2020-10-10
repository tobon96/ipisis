package com.ipisis.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdeaMateriaDTO {

    private List<MateriaDTO> cursos = new ArrayList<>();
    private List<MateriaDTO> prerrequisitos = new ArrayList<>();
}
