package com.gimnasio.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gimnasio.model.entities.Actividad;
import com.gimnasio.model.repositories.ActividadRepository;


@CrossOrigin
@RestController
public class ActividadController {
	
	@Autowired
	ActividadRepository actividadRep;
	
	@GetMapping("/inicio")
	public List<Actividad> getAllActividades (HttpServletRequest request) {
		
		return this.actividadRep.getAllActividades();
	}
	
	@GetMapping("/actividad/get")
	public DTO getActividad (int id) {
		Actividad act = actividadRep.findById(id).get();
		return getDTOFromActividad(act);
	}
	
	private DTO getDTOFromActividad(Actividad act) {
		DTO dto = new DTO();
		if(act != null) {
			dto.put("id", act.getId());
			dto.put("nombre", act.getNombre());
			dto.put("descripcion", act.getDescripcion());
			dto.put("lugar", act.getLugar());
			dto.put("monitor", act.getMonitor());
			dto.put("imagen", act.getImagen());
		}
		return dto;
	}

}
