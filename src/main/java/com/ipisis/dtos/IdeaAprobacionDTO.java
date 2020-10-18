package com.ipisis.dtos;

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
public class IdeaAprobacionDTO {

    @NotNull(message = "La lista de ideas enviada no puede ser null")
    @NotEmpty(message = "La lista de ideas enviada no puede ser vacía")
    private List<Integer> ideas;

    @NotNull(message = "La observación no puede ser null")
    @NotEmpty(message = "La observación no puede ser vacía")
    private String observacion;

    @NotNull(message = "El estado no puede ser null")
    @NotEmpty(message = "El estado no puede ser vacío")
    private String estado;
}
