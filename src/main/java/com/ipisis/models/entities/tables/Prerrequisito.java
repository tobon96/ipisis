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
    @GeneratedValue
    private int id;

    @Column(name = "idea_id")
    private int ideaId;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Materia materia;
}
