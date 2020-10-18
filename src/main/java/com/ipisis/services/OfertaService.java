package com.ipisis.services;

import com.ipisis.mappers.OfertaDTO;
import com.ipisis.models.entities.tables.Oferta;
import com.ipisis.models.responses.DetallePeticionResponse;
import com.ipisis.repositories.OfertaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OfertaService {

    private final OfertaRepository ofertaRepository;

    public OfertaService(OfertaRepository ofertaRepository) {
        this.ofertaRepository = ofertaRepository;
    }

    public DetallePeticionResponse crearOfertas(OfertaDTO ofertaDTO) {

        ofertaDTO.getTutoresId().forEach(tutorId -> {
            //Todo enviar correo a los tutores

            ofertaRepository.save(Oferta.builder()
                    .ideaId(ofertaDTO.getIdeaId())
                    .idProfesor(tutorId)
                    .semestre(ofertaDTO.getSemestre())
                    .build());
        });

        return DetallePeticionResponse.builder()
                .timestamp(new Date())
                .peticion("Creación de ofertas")
                .detalle("Se completó la creación de las ofertas con éxito")
                .build();
    }
}
