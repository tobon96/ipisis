package com.ipisis.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdeaDTO {

    private int ideaId;

    @NotNull(message = "El título de la idea no puede ser null")
    private String titulo;

    @NotNull(message = "La descripción de la idea no puede ser null")
    private String descripcion;

    @NotNull(message = "La cantidad de grupos permitidos en la idea no puede ser null")
    @Min(value = 1, message = "El mínimo de grupos por idea debe ser de 1")
    private int grupos;

    @NotNull(message = "La cantidad de integrantes no debe ser null")
    @Min(value = 2, message = "El mínimo de estudiantes por grupo debe ser de 2")
    @Max(value = 3, message = "El máximo de estudiantes por grupo debe ser de 3")
    private int integrantes;

    @Valid
    @NotNull(message = "Se debe enviar el objeto con la lista de cursos y prerrequisitos")
    private IdeaMateriasDTO materias;

    @Valid
    @NotNull(message = "Se debe enviar el objeto con la lista de proponentes de la idea")
    @NotEmpty(message = "La lista de proponentes no debe estar vacía")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<@Valid IdeaProponenteDTO> proponentes;

}
