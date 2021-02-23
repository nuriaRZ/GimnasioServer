package com.gimnasio.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the sesion database table.
 * 
 */
@Entity
@NamedQuery(name="Sesion.findAll", query="SELECT s FROM Sesion s")
public class Sesion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String dificultad;

	private int plazas;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="sesion")
	@JsonIgnore
	private List<Reserva> reservas;

	//bi-directional many-to-one association to Actividad
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_actividad")
	private Actividad actividad;

	//bi-directional many-to-one association to Horario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_horario")
	
	private Horario horario;

	public Sesion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDificultad() {
		return this.dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public int getPlazas() {
		return this.plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setSesion(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setSesion(null);

		return reserva;
	}

	public Actividad getActividad() {
		return this.actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Horario getHorario() {
		return this.horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

}