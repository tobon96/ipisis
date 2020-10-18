package com.ipisis.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SemestreDTO {

    @NotNull(message = "El código del semestre no puede ser null")
    @NotEmpty(message = "El código del semestre no puede ser vacío")
    private String codigo;

    @NotNull(message = "La fecha de inicio de semestre no puede ser null")
    @NotEmpty(message = "La fecha de inicio de semestre no puede ser vacía")
    @Pattern(regexp="^\\d{4}[\\-]?((((0[13578])|(1[02]))[\\-]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-]?(([0-2][0-9])|(30)))|(02[\\-]?[0-2][0-9]))$", message = "La fecha de inicio de semestre no cumple con el formato aaaa-mm-dd o se ingresa una fecha que no puede ser cumplida")
    private String inicioSemestre;

    @NotNull(message = "La fecha de cierre de semestre no puede ser null")
    @NotEmpty(message = "La fecha de cierre de semestre no puede ser vacía")
    @Pattern(regexp="^\\d{4}[\\-]?((((0[13578])|(1[02]))[\\-]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-]?(([0-2][0-9])|(30)))|(02[\\-]?[0-2][0-9]))$", message = "La fecha de cierre de semestre no cumple con el formato aaaa-mm-dd o se ingresa una fecha que no puede ser cumplida")
    private String cierreSemestre;

    @NotNull(message = "La fecha de inicio de inscripciones no puede ser null")
    @NotEmpty(message = "La fecha de inicio de inscripciones no puede ser vacía")
    @Pattern(regexp="^\\d{4}[\\-]?((((0[13578])|(1[02]))[\\-]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-]?(([0-2][0-9])|(30)))|(02[\\-]?[0-2][0-9]))$", message = "La fecha de inicio de inscripciones no cumple con el formato aaaa-mm-dd o se ingresa una fecha que no puede ser cumplida")
    private String inicioInscripcion;

    @NotNull(message = "La fecha de cierre de inscripciones no puede ser null")
    @NotEmpty(message = "La fecha de cierre de inscripciones no puede ser vacía")
    @Pattern(regexp="^\\d{4}[\\-]?((((0[13578])|(1[02]))[\\-]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-]?(([0-2][0-9])|(30)))|(02[\\-]?[0-2][0-9]))$", message = "La fecha de cierre de inscripciones no cumple con el formato aaaa-mm-dd o se ingresa una fecha que no puede ser cumplida")
    private String cierreInscripcion;

}
