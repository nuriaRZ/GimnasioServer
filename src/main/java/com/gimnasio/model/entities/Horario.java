package com.gimnasio.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the horario database table.
 * 
 */
@Entity
@NamedQuery(name="Horario.findAll", query="SELECT h FROM Horario h")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="hora_fin")
	private String horaFin;

	@Column(name="hora_inicio")
	private String horaInicio;

	//bi-directional many-to-one association to Sesion
	@OneToMany(mappedBy="horario")
	@JsonIgnore
	private List<Sesion> sesions;

	public Horario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoraFin() {
		return this.horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public String getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public List<Sesion> getSesions() {
		return this.sesions;
	}

	public void setSesions(List<Sesion> sesions) {
		this.sesions = sesions;
	}

	public Sesion addSesion(Sesion sesion) {
		getSesions().add(sesion);
		sesion.setHorario(this);

		return sesion;
	}

	public Sesion removeSesion(Sesion sesion) {
		getSesions().remove(sesion);
		sesion.setHorario(null);

		return sesion;
	}

}