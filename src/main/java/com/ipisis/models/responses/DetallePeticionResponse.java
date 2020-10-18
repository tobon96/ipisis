package com.ipisis.models.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetallePeticionResponse {

    private Date timestamp;
    private String peticion;
    private String detalle;
}
