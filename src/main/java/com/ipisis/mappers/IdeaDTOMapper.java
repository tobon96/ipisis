package com.ipisis.mappers;

import com.ipisis.constants.MapeosConstants;
import com.ipisis.dtos.IdeaDTO;
import com.ipisis.dtos.IdeaMateriasDTO;
import com.ipisis.dtos.MateriaDTO;
import com.ipisis.models.entities.tables.Idea;

import java.util.stream.Collectors;

public class IdeaDTOMapper {

    public static IdeaDTO mapearIdea(Idea idea) {

        IdeaDTO ideaDTO = IdeaDTO.builder()
                .ideaId(idea.getId())
                .titulo(idea.getTitulo())
                .descripcion(idea.getDescripcion())
                .grupos(idea.getEquipos())
                .integrantes(idea.getMiembros())
                .build();

        IdeaMateriasDTO ideaMateriaDTO = IdeaMateriasDTO.builder().build();

        ideaMateriaDTO.setCursos(idea
                .getMaterias().stream()
                .filter(miv -> miv.getTipoMateria().equals(MapeosConstants.CURSO))
                .map(miv -> new MateriaDTO(miv.getMateriaId(), miv.getMateria()))
                .collect(Collectors.toList()));

        ideaMateriaDTO.setPrerrequisitos(idea
                .getMaterias().stream()
                .filter(miv -> miv.getTipoMateria().equals(MapeosConstants.PRERREQUISITO))
                .map(miv -> new MateriaDTO(miv.getMateriaId(), miv.getMateria()))
                .collect(Collectors.toList()));
        ideaDTO.setMaterias(ideaMateriaDTO);

        return ideaDTO;
    }
}
