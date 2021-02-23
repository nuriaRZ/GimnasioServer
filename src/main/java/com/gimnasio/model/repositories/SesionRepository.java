package com.gimnasio.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gimnasio.model.entities.Sesion;

public interface SesionRepository extends CrudRepository<Sesion, Integer> {
	@Query(value = "SELECT * FROM sesion as s, actividad as a, horario as h where s.id_actividad = a.id and s.id_horario = h.id and s.id_actividad=? order by h.id", nativeQuery = true)
	public List<Sesion> getSesionesPorActividad(int idActividad);
}
