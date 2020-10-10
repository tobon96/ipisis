package com.ipisis.models.entities.views;

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
@Table(name = "vista_materias_idea")
@IdClass(MateriaIdeaViewCompositeKey.class)
public class MateriaIdeaView {

    @Id
    @Column(name = "idea")
    private int ideaId;

    @Id
    @Column(name = "cod_materia")
    private int materiaId;

    @Column(name = "materia")
    private String materia;

    @Column(name = "tipo")
    private String tipoMateria;

}
