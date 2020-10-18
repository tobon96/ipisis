package com.ipisis.services;

import com.ipisis.dtos.ProfesorDTO;
import com.ipisis.mappers.ProfesorDTOMapper;
import com.ipisis.repositories.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public List<ProfesorDTO> obtenerProfesores() {
        return profesorRepository.findAll().stream()
                .map(ProfesorDTOMapper::mapearProfesor)
                .collect(Collectors.toList());
    }
}
