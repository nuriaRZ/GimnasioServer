package com.gimnasio.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gimnasio.jwtSecurity.AutenticadorJWT;
import com.gimnasio.model.entities.Reserva;
import com.gimnasio.model.entities.Sesion;
import com.gimnasio.model.entities.Usuario;
import com.gimnasio.model.repositories.ReservaRepository;
import com.gimnasio.model.repositories.SesionRepository;
import com.gimnasio.model.repositories.UsuarioRepository;


@CrossOrigin
@RestController
public class ReservaController {
	@Autowired UsuarioRepository usuRep;
	@Autowired ReservaRepository reservaRep;
	@Autowired SesionRepository sesionRep;
	
	@PutMapping("/reserva/nueva")
	private DTO nuevaReserva (@RequestBody DatosNuevaReserva datosNuevaReserva, HttpServletRequest request) {
		DTO dto = new DTO(); // Voy a devolver un dto
		dto.put("result", "fail"); // Asumo que voy a fallar, si todo va bien se sobrescribe este valor
		int idUsuAutenticado = AutenticadorJWT.getIdUsuarioDesdeJwtIncrustadoEnRequest(request); // Obtengo el usuario autenticado, por su JWT
		try {
			// Localizo el usuario autenticado, será el emisor del mensaje
			
			Usuario usuAutenticado = this.usuRep.findById(idUsuAutenticado).get();
			
			int idSesion = AutenticadorJWT.getIdSesionDesdeJwtIncrustadoEnRequest(request);
			Sesion sesion = this.sesionRep.findById(idSesion).get();
			
		   
		    	Reserva r = new Reserva();
		    	r.setSesion(sesion);
		    	r.setUsuario(usuAutenticado);
		    	r.setFecha(new Date());
		    	int plazas = r.getSesion().getPlazas();
		    	r.getSesion().setPlazas(plazas - 1);
		    	
		    	// Guardo el mensaje
		    	this.reservaRep.save(r);
		    	
		    	
		    	
		    	// indico que todo ha funcionado correctamente
				dto.put("result", "ok");
		    
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dto;
	}
}

class DatosNuevaReserva {
	Date fecha;
	boolean activa;
	int idSesion;
	int idUsuario;	
	
	public DatosNuevaReserva(Date fecha, boolean activa, int idSesion, int idUsuario) {
		super();
		this.fecha = fecha;
		this.activa = activa;
		this.idSesion = idSesion;
		this.idUsuario = idUsuario;
	}
}
