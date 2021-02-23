package com.gimnasio.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gimnasio.model.entities.Horario;

@Repository
public interface HorarioRepository extends CrudRepository<Horario, Integer> {

}
