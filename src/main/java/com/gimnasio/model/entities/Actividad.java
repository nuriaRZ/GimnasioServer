package com.gimnasio.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the actividad database table.
 * 
 */
@Entity
@NamedQuery(name="Actividad.findAll", query="SELECT a FROM Actividad a")
public class Actividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	private String imagen;

	private String lugar;

	private String monitor;

	private String nombre;

	//bi-directional many-to-one association to Sesion
	@OneToMany(mappedBy="actividad")
	@JsonIgnore
	private List<Sesion> sesions;

	public Actividad() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getMonitor() {
		return this.monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Sesion> getSesions() {
		return this.sesions;
	}

	public void setSesions(List<Sesion> sesions) {
		this.sesions = sesions;
	}

	public Sesion addSesion(Sesion sesion) {
		getSesions().add(sesion);
		sesion.setActividad(this);

		return sesion;
	}

	public Sesion removeSesion(Sesion sesion) {
		getSesions().remove(sesion);
		sesion.setActividad(null);

		return sesion;
	}

}