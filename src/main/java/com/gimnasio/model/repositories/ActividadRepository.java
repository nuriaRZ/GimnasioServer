package com.gimnasio.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.gimnasio.model.entities.Actividad;

@Repository
public interface ActividadRepository extends CrudRepository<Actividad, Integer>{
	@Query(value = "SELECT * FROM actividad", nativeQuery = true)
	public List<Actividad> getAllActividades();
	
	
}


