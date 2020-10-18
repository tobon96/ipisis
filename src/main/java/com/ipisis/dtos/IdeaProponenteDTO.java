package com.ipisis.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdeaProponenteDTO {

    @NotNull(message = "El tipo de proponente no puede ser null")
    @NotEmpty(message = "El tipo de proponente no puede ser vacío")
    private String tipo;

    @NotNull(message = "El nombre de proponente no puede ser null")
    @NotEmpty(message = "El nombre de proponente no puede ser vacío")
    private String nombre;

    @NotNull(message = "El correo de proponente no puede ser null")
    @NotEmpty(message = "El correo de proponente no puede ser vacío")
    private String correo;
}
