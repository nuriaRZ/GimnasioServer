package com.gimnasio.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gimnasio.model.entities.Reserva;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Integer> {
	

}
