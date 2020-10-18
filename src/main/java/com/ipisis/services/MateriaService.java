package com.ipisis.services;

import com.ipisis.constants.ServiciosConstants;
import com.ipisis.dtos.MateriaDTO;
import com.ipisis.mappers.MateriaDTOMapper;
import com.ipisis.models.entities.tables.Materia;
import com.ipisis.repositories.MateriaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MateriaService {

    private final MateriaRepository materiaRepository;

    public MateriaService(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    public MateriaDTO obtenerMateria(int id) {
        Optional<Materia> materia = materiaRepository.findById(id);
        return materia.map(MateriaDTOMapper::mapearMateria).orElse(null);
    }

    public List<MateriaDTO> obtenerMaterias() {
        List<Materia> materias = materiaRepository.findAll();

        return materias.stream()
                .map(MateriaDTOMapper::mapearMateria)
                .collect(Collectors.toList());
    }

    public List<MateriaDTO> obtenerListaCursos() {
        HashSet<Integer> cursos = new HashSet<>(Arrays.asList(ServiciosConstants.PI_I, ServiciosConstants.PI_II));

        List<Materia> materias = materiaRepository.findAllByIdIn(cursos);

        return materias.stream()
                .map(MateriaDTOMapper::mapearMateria)
                .collect(Collectors.toList());
    }
}
