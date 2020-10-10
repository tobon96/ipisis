package com.ipisis.models.entities.tables;

import com.ipisis.models.entities.views.MateriaIdeaView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "idea")
public class Idea {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "num_miembros")
    private Integer miembros;

    @Column(name = "num_equipos")
    private Integer equipos;

    @Column(name = "max_miembros")
    private Integer maxMiembros;

    @OneToMany(targetEntity = MateriaIdeaView.class, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "idea", referencedColumnName = "id")
    private List<MateriaIdeaView> materias;
}
