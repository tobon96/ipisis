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
@Table(name = "idea_materia")
public class IdeaMateria {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "idea_id")
    private int ideaId;

    @Column(name = "materia_codigo", insertable = false, updatable = false)
    private int materiaId;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Materia materia;
}
