package com.ipisis.models.entities.tables;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "semestre")
public class Semestre {

    @Id
    @Column(name = "codigo")
    private String codigo;

    @Column(name = "semestre_inicio")
    private Date inicioSemestre;

    @Column(name = "semestre_cierre")
    private Date cierreSemestre;

    @Column(name = "inscripcion_inicio")
    private Date inicioInscripcion;

    @Column(name = "inscripcion_cierre")
    private Date cierreInscripcion;
}
