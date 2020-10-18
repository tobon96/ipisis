package com.ipisis.services;

import com.ipisis.dtos.IdeaDTO;
import com.ipisis.mappers.IdeaDTOMapper;
import com.ipisis.models.entities.tables.Idea;
import com.ipisis.models.entities.tables.IdeaMateria;
import com.ipisis.models.entities.tables.Prerrequisito;
import com.ipisis.models.entities.tables.Proponente;
import com.ipisis.repositories.IdeaMateriaRepository;
import com.ipisis.repositories.IdeaRepository;
import com.ipisis.repositories.PrerrequisitoRepository;
import com.ipisis.repositories.ProponenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    public IdeaService(IdeaRepository ideaRepository, IdeaMateriaRepository ideaMateriaRepository, PrerrequisitoRepository prerrequisitoRepository, ProponenteRepository proponenteRepository) {
        this.ideaRepository = ideaRepository;
        this.ideaMateriaRepository = ideaMateriaRepository;
        this.prerrequisitoRepository = prerrequisitoRepository;
        this.proponenteRepository = proponenteRepository;
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

            ideaDTO.setIdeaId(idea.getId());

            return ideaDTO;
        } catch (Exception e) {
            log.error("Ocurrió un error creando la idea: " + ideaDTO.toString());
            return null;
        }
    }
}
