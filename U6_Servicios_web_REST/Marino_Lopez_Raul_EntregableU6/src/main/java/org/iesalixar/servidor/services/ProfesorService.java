package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Profesor;

public interface ProfesorService {
	
	public List<Profesor> getAllProfesors();
	public Profesor actualizarProfesor(Profesor profesor);
	public Profesor findProfesorById(Long id);
	public Profesor insertarProfesor(Profesor profesor);
	public Profesor getProfesorByName(String nombre);
	public List<Profesor>findByDepartamento(Long departamento);
	public Optional<Profesor> findDepartamentoById(Long id);
}
