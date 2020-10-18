package com.ipisis.mappers;

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
public class OfertaDTO {

    @NotNull(message = "El id de la idea no puede ser null")
    private Integer ideaId;

    @NotNull(message = "La lista de tutores no puede ser null")
    private List<Integer> tutoresId;

    @NotNull(message = "El código del semestre no puede ser null")
    @NotEmpty(message = "El códigp del semestre no puede ser vacío")
    private String semestre;
}
