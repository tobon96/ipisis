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
@Table(name = "prerrequisito")
public class Prerrequisito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "idea_id")
    private int ideaId;

    @Column(name = "materia_codigo")
    private int codigoMateria;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "materia_codigo", insertable = false, updatable = false)
    private Materia materia;
}
