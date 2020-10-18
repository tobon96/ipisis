package com.ipisis.services;

import com.ipisis.constants.EntidadesConstants;
import com.ipisis.dtos.IdeaAprobacionDTO;
import com.ipisis.dtos.IdeaDTO;
import com.ipisis.mappers.IdeaDTOMapper;
import com.ipisis.models.entities.tables.*;
import com.ipisis.models.responses.DetallePeticionResponse;
import com.ipisis.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class IdeaService {

    private final IdeaRepository ideaRepository;
    private final IdeaMateriaRepository ideaMateriaRepository;
    private final PrerrequisitoRepository prerrequisitoRepository;
    private final ProponenteRepository proponenteRepository;
    private final IdeaHistorialRepository ideaHistorialRepository;

    public IdeaService(IdeaRepository ideaRepository, IdeaMateriaRepository ideaMateriaRepository, PrerrequisitoRepository prerrequisitoRepository, ProponenteRepository proponenteRepository, IdeaHistorialRepository ideaHistorialRepository) {
        this.ideaRepository = ideaRepository;
        this.ideaMateriaRepository = ideaMateriaRepository;
        this.prerrequisitoRepository = prerrequisitoRepository;
        this.proponenteRepository = proponenteRepository;
        this.ideaHistorialRepository = ideaHistorialRepository;
    }

    public IdeaDTO obtenerIdea(int id) {
        Optional<Idea> idea = ideaRepository.findById(id);
        return idea.map(IdeaDTOMapper::mapearIdea).orElse(null);
    }

    public List<IdeaDTO> obtenerIdeas() {
        List<Idea> ideas = ideaRepository.findAll();

        return ideas.stream()
                .map(IdeaDTOMapper::mapearIdea)
                .collect(Collectors.toList());
    }



    public IdeaDTO crearIdea(IdeaDTO ideaDTO) {

        try {
            Idea idea = ideaRepository.save(Idea.builder()
                    .titulo(ideaDTO.getTitulo())
                    .descripcion(ideaDTO.getDescripcion())
                    .miembros(ideaDTO.getIntegrantes())
                    .equipos(ideaDTO.getGrupos())
                    .build());

            ideaDTO.getMaterias().getCursos()
                    .forEach(materiaDTO -> ideaMateriaRepository.save(IdeaMateria.builder()
                            .ideaId(idea.getId())
                            .materiaId(materiaDTO.getCodigo())
                            .build()));

            ideaDTO.getMaterias().getPrerrequisitos()
                    .forEach(materiaDTO -> prerrequisitoRepository.save(Prerrequisito.builder()
                            .ideaId(idea.getId())
                            .codigoMateria(materiaDTO.getCodigo())
                            .build()));

            ideaDTO.getProponentes()
                    .forEach(ideaProponenteDTO -> proponenteRepository.save(Proponente.builder()
                            .ideaId(idea.getId())
                            .tipo(ideaProponenteDTO.getTipo())
                            .nombre(ideaProponenteDTO.getNombre())
                            .correo(ideaProponenteDTO.getCorreo())
                            .build()));

            ideaHistorialRepository.save(IdeaHistorial.builder()
                    .ideaId(idea.getId())
                    .fechaActualizacion(new Date())
                    .observacion(EntidadesConstants.OBSERVACION_IDEA_CREADA)
                    .estado(EntidadesConstants.ESTADO_IDEA_CREADA)
                    .build());

            ideaDTO.setIdeaId(idea.getId());

            return ideaDTO;
        } catch (Exception e) {
            log.error("Ocurrió un error creando la idea: " + ideaDTO.toString());
            return null;
        }
    }

    public DetallePeticionResponse procesarIdeas(IdeaAprobacionDTO ideaAprobacionDTO) {

        ideaAprobacionDTO.getIdeas().forEach(ideaId -> {
            //Todo Enviar correo de cambio de estado de las ideas

            if(ideaAprobacionDTO.getEstado().equals("APROBADA")) {
                ideaHistorialRepository.save(IdeaHistorial.builder()
                        .ideaId(ideaId)
                        .fechaActualizacion(new Date())
                        .observacion(ideaAprobacionDTO.getObservacion())
                        .estado(EntidadesConstants.ESTADO_IDEA_APROBADA)
                        .build());
            } else if(ideaAprobacionDTO.getEstado().equals("RECHAZADA")) {
                ideaHistorialRepository.save(IdeaHistorial.builder()
                        .ideaId(ideaId)
                        .fechaActualizacion(new Date())
                        .observacion(ideaAprobacionDTO.getObservacion())
                        .estado(EntidadesConstants.ESTADO_IDEA_RECHAZADA)
                        .build());
            }


        });

        return new DetallePeticionResponse();
    }
}
