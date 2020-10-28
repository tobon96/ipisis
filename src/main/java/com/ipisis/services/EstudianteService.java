package com.ipisis.services;

import com.ipisis.dtos.EstudianteDTO;
import com.ipisis.mappers.EstudianteMapper;
import com.ipisis.models.entities.tables.Estudiante;
import com.ipisis.repositories.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public EstudianteDTO obtenerEstudiante(int id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        return estudiante.map(EstudianteMapper::mapearEstudiante).orElse(null);
    }
}
