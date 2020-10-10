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
public class DetalleErrorResponse {

    private Date timestamp;
    private String error;
    private String detalle;

}
