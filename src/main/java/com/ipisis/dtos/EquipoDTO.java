package com.ipisis.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EquipoDTO {

    private int id;

    @NotNull(message = "La lista de estudiantes no puede ser null")
    @NotEmpty(message = "La lista de estudiantes no puede ser vacía")
    private List<Integer> idEstudiantes;

    @NotNull(message = "El nombre del equipo no puede ser null")
    @NotEmpty(message = "El nombre del equipo no puede ser vacío")
    private String nombre;

}
