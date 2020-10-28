package com.ipisis.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDTO {

    private int id;

    private String identificacion;

    private String usuario;

    private String nombre;

    private String correo;
}
