package com.gimnasio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gimnasio.model.entities.Actividad;
import com.gimnasio.model.entities.Horario;
import com.gimnasio.model.repositories.HorarioRepository;

@CrossOrigin
@RestController
public class HorarioController {
	@Autowired
	HorarioRepository horarioRep;
	
	@GetMapping("horario/all")
	public Iterable<Horario> getAllHorarios(){
		return this.horarioRep.findAll();
	}
	
	@GetMapping("horario/get")
	public DTO getHorario (int id) {
		Horario h = horarioRep.findById(id).get();
		return getDTOFromActividad(h);
	}
	
	private DTO getDTOFromActividad(Horario h) {
		DTO dto = new DTO();
		if(h != null) {
			dto.put("id", h.getId());
			dto.put("horaInicio", h.getHoraInicio());
			dto.put("horaFin", h.getHoraFin());
			
		}
		return dto;
	}
	

}
