package com.ipisis.models.entities.tables;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "materia")
public class Materia {

    @Id
    @Column(name = "codigo")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "electiva")
    private boolean electiva;

    @Column(name = "admin_proyecto")
    private boolean adminProyecto;
}
