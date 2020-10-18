package com.ipisis.services;

import com.ipisis.dtos.SemestreDTO;
import com.ipisis.mappers.SemestreDTOMapper;
import com.ipisis.models.entities.tables.Semestre;
import com.ipisis.repositories.SemestreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SemestreService {

    private final SemestreRepository semestreRepository;

    public SemestreService(SemestreRepository semestreRepository) {
        this.semestreRepository = semestreRepository;
    }

    public List<SemestreDTO> obtenerSemestres() {
        return semestreRepository.findAll().stream()
                .map(SemestreDTOMapper::mapearSemestre)
                .collect(Collectors.toList());
    }


    public SemestreDTO crearSemestre(SemestreDTO semestreDTO) {

        try {
            semestreRepository.save(Semestre.builder()
                    .codigo(semestreDTO.getCodigo())
                    .inicioSemestre(SemestreDTOMapper.df.parse(semestreDTO.getInicioSemestre()))
                    .cierreSemestre(SemestreDTOMapper.df.parse(semestreDTO.getCierreSemestre()))
                    .inicioInscripcion(SemestreDTOMapper.df.parse(semestreDTO.getInicioInscripcion()))
                    .cierreInscripcion(SemestreDTOMapper.df.parse(semestreDTO.getCierreInscripcion()))
                    .build());

        } catch (Exception e) {
            return null;
        }

        return semestreDTO;
    }

    public void eliminarSemestre(String id) {
        try {
            semestreRepository.deleteById(id);
        } catch (Exception e) {
            log.error("No se pudo eliminar el semestre con id " + id);
        }

    }

    public SemestreDTO actualizarSemestre(SemestreDTO semestreDTO, String id) {

        try {
            semestreRepository.save(Semestre.builder()
                    .codigo(id)
                    .inicioSemestre(SemestreDTOMapper.df.parse(semestreDTO.getInicioSemestre()))
                    .cierreSemestre(SemestreDTOMapper.df.parse(semestreDTO.getCierreSemestre()))
                    .inicioInscripcion(SemestreDTOMapper.df.parse(semestreDTO.getInicioInscripcion()))
                    .cierreInscripcion(SemestreDTOMapper.df.parse(semestreDTO.getCierreInscripcion()))
                    .build());
        } catch (Exception e) {
            return null;
        }

        return semestreDTO;
    }
}
