package com.ipisis.services;

import com.ipisis.dtos.IdeaDTO;
import com.ipisis.dtos.IdeaMateriaDTO;
import com.ipisis.dtos.MateriaDTO;
import com.ipisis.models.entities.tables.Idea;
import com.ipisis.repositories.IdeaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IdeaService {

    private final IdeaRepository ideaRepository;

    public IdeaService(IdeaRepository ideaRepository) {
        this.ideaRepository = ideaRepository;
    }

    public IdeaDTO obtenerIdea(int id) {
        Optional<Idea> idea = ideaRepository.findById(id);

        if(idea.isPresent()) {

            IdeaDTO ideaDTO = IdeaDTO.builder()
                    .ideaId(idea.get().getId())
                    .titulo(idea.get().getTitulo())
                    .grupos(idea.get().getEquipos())
                    .integrantes(idea.get().getMiembros())
                    .build();

            IdeaMateriaDTO ideaMateriaDTO = IdeaMateriaDTO.builder().build();

            ideaMateriaDTO.setCursos(idea.get()
                    .getMaterias().stream()
                    .filter(miv -> miv.getTipoMateria().equals("Curso"))
                    .map(miv -> new MateriaDTO(miv.getMateriaId(), miv.getMateria()))
                    .collect(Collectors.toList()));

            ideaMateriaDTO.setPrerrequisitos(idea.get()
                    .getMaterias().stream()
                    .filter(miv -> miv.getTipoMateria().equals("Prerrequisito"))
                    .map(miv -> new MateriaDTO(miv.getMateriaId(), miv.getMateria()))
                    .collect(Collectors.toList()));
            ideaDTO.setMaterias(ideaMateriaDTO);

            return ideaDTO;
        } else {
            return null;
        }
    }
}
