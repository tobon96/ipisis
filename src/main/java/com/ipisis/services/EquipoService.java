package com.ipisis.services;

import com.ipisis.constants.ServiciosConstants;
import com.ipisis.dtos.EquipoDTO;
import com.ipisis.dtos.EquipoEstudianteDTO;
import com.ipisis.dtos.EquipoInvitacionProcesamientoDTO;
import com.ipisis.mappers.EquipoMapper;
import com.ipisis.models.entities.tables.Equipo;
import com.ipisis.models.entities.tables.EquipoEstudiante;
import com.ipisis.models.responses.DetallePeticionResponse;
import com.ipisis.repositories.EquipoEstudianteRepository;
import com.ipisis.repositories.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipoService {

    private final EquipoRepository equipoRepository;
    private final EquipoEstudianteRepository equipoEstudianteRepository;

    public EquipoService(EquipoRepository equipoRepository, EquipoEstudianteRepository equipoEstudianteRepository) {
        this.equipoRepository = equipoRepository;
        this.equipoEstudianteRepository = equipoEstudianteRepository;
    }

    public EquipoDTO crearEquipo(EquipoDTO equipoDTO) {

        Equipo equipo = equipoRepository.save(Equipo.builder()
                .nombre(equipoDTO.getNombre())
                .fechaCreacion(new Date())
                .build());

        equipoDTO.setId(equipo.getId());

        equipoDTO.getIdEstudiantes().forEach(id -> {
            equipoEstudianteRepository.save(EquipoEstudiante.builder()
                    .estadoInvitacion(ServiciosConstants.INV_EQUIPO_PTE)
                    .idEquipo(equipo.getId())
                    .idEstudiante(id)
                    .build());
        });

        return equipoDTO;
    }

    public DetallePeticionResponse procesarInvitacion(EquipoInvitacionProcesamientoDTO invitacionProcesamientoDTO) {

        EquipoEstudiante equipoEstudiante = equipoEstudianteRepository.findByIdEquipoAndIdEstudiante(invitacionProcesamientoDTO.getIdEquipo(), invitacionProcesamientoDTO.getIdEstudiante());
        equipoEstudiante.setEstadoInvitacion(invitacionProcesamientoDTO.getEstado());

        return DetallePeticionResponse.builder()
                .peticion("Procesar invitación")
                .detalle("Estado de la invitación procesado con éxito. Estado actual: " + invitacionProcesamientoDTO.getEstado())
                .timestamp(new Date())
                .build();
    }

    public List<EquipoEstudianteDTO> obtenerEquipos(int id) {

        List<EquipoEstudiante> equiposEstudiante = equipoEstudianteRepository.findAllByIdEstudianteAndEstadoInvitacionIsNot(id, ServiciosConstants.INV_EQUIPO_RECHAZADA);
        return equiposEstudiante.stream()
                .map(EquipoMapper::mapearEquipoEstudiante)
                .collect(Collectors.toList());
    }
}
