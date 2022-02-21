package org.iesalixar.servidor.repository;


import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Profesor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor,Long>{
	
	public Profesor findByNombre(String nombre);
	public Optional<Profesor> findById(Long id);
//	List<Profesor> findByDepartamento(Long departamento);
}
