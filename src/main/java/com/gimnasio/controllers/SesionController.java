package com.gimnasio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gimnasio.jwtSecurity.AutenticadorJWT;
import com.gimnasio.model.entities.Sesion;
import com.gimnasio.model.repositories.HorarioRepository;
import com.gimnasio.model.repositories.SesionRepository;

@CrossOrigin
@RestController
public class SesionController {
	@Autowired
	SesionRepository sesionRep;
	@Autowired
	HorarioRepository horarioRep;
	
	@GetMapping("/sesiones")
	public List<Sesion> getSesionesPorActividad (int idActividad){
		return this.sesionRep.getSesionesPorActividad(idActividad);
		
	}
	

}

class DatosSesion {
	int plazas;
	String dificultad;
	
	public DatosSesion(int plazas, String dificultad) {
		super();
		this.plazas = plazas;
		this.dificultad = dificultad;
	}
}
