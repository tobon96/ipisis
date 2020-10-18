package com.ipisis.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdeaMateriasDTO {

    @NotNull(message = "La lista de cursos no puede ser null")
    @NotEmpty(message = "La lista de cursos no puede estar vacía")
    private List<@Valid MateriaDTO> cursos;

    @NotNull(message = "La lista de prerrequisitos no puede ser null")
    @NotEmpty(message = "La lista de prerrquisitos no puede estar vacía")
    private List<@Valid MateriaDTO> prerrequisitos;
}
