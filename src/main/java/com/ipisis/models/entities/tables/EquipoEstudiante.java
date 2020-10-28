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
@Table(name = "equipo_estudiante")
public class EquipoEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "estado_invitacion")
    private String estadoInvitacion;

    @Column(name = "estado_acta")
    private String estadoActa;

    @Column(name = "equipo_codigo")
    private int idEquipo;

    @Column(name = "estudiante_id")
    private int idEstudiante;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "equipo_codigo", insertable = false, updatable = false)
    private Equipo equipo;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_id", insertable = false, updatable = false)
    private Estudiante estudiante;
}
