package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departamento")
public class Departamento implements Serializable {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true, nullable=false)
	private String nombre;
	
	@OneToMany(mappedBy="id",cascade=CascadeType.ALL,orphanRemoval = true)
	private Set<Profesor> profesor = new HashSet<>(); 
	
	public Departamento() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Set<Profesor> getProfesor() {
		return profesor;
	}

	public void setProfesor(Set<Profesor> profesor) {
		this.profesor = profesor;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, profesor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(profesor, other.profesor);
	}

	//Métodos HELPERs	
	public void addProfesor(Profesor profesor)  {
		this.profesor.add(profesor);
		profesor.setDepartamento(this);
	}
	
	public void removeProfesor(Profesor profesor) {
		this.profesor.remove(profesor);
		profesor.setDepartamento(null);
	}
	
	

	
	
}
