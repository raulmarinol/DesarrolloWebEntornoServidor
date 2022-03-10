package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="profesor")
public class Profesor implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true,length=9,nullable=true)
	private String nif;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String apellido1;
	
	@Column(nullable=true)
	private String apellido2;
	
	@Column(nullable=false)
	private String ciudad;
	
	@Column(nullable=false)
	private String direccion;
		
	@Column(nullable=true)
	private String telefono;
	
	@Column(name="fecha_nacimiento",nullable=false)
	private Date fechaNacimiento;
	
	@Column(nullable=false,length=1)
	private String sexo;
	
	@ManyToOne
	@JoinColumn(name = "id_departamento")
	private Departamento departamento;

	@OneToMany(mappedBy="profesor", cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Asignatura> asignaturas = new HashSet<>();
	
	public Profesor() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNif() {
		return nif;
	}


	public void setNif(String nif) {
		this.nif = nif;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido1() {
		return apellido1;
	}


	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	public String getApellido2() {
		return apellido2;
	}


	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}


	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(id, other.id);
	}


	//Métodos HELPERs	
	public void addAsignatura(Asignatura asginatura)  {
		this.asignaturas.add(asginatura);
		asginatura.setProfesor(this);
	}
	
	public void removeAsignatura(Asignatura asginatura) {
		this.asignaturas.remove(asginatura);
		asginatura.setProfesor(null);
	}


	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nif=" + nif + ", nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", ciudad=" + ciudad + ", direccion=" + direccion + ", telefono="
				+ telefono + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + "]";
	}

}
