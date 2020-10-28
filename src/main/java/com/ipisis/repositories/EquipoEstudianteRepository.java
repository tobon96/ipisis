package com.ipisis.repositories;

import com.ipisis.models.entities.tables.EquipoEstudiante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoEstudianteRepository extends CrudRepository<EquipoEstudiante, Integer> {

    EquipoEstudiante findByIdEquipoAndIdEstudiante(int idEquipo, int idEstudiante);

    List<EquipoEstudiante> findAllByIdEstudianteAndEstadoInvitacionIsNot(int idEstudiante, String estadoInvitacion);
}
