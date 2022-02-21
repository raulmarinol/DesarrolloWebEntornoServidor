package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImpl implements ProfesorService{
	
	@Autowired
	ProfesorRepository profesorRepo;

	@Override
	public List<Profesor> getAllProfesors() {	
		
		//Obtengo el resultado a través del repositorio
		List<Profesor> deptsBD = profesorRepo.findAll();	
		
		
		//Verificando que he obtenido algo 
		if (deptsBD!= null && deptsBD.size()> 0) {
			
			return deptsBD;
		}
		
		//No he obtenido nada devuelvo una lista vacía (para no devolver nulo)
		return new ArrayList<Profesor>(); 
		
	}

	@Override
	public Profesor actualizarProfesor(Profesor profesor) {
		if (profesor==null || profesor.getId() ==null || profesor.getNombre()==null) {
			return null;
		}
		
		return profesorRepo.save(profesor); 
	}

	@Override
	public Profesor findProfesorById(Long id) {
		return profesorRepo.findById(id).get();
	}

	@Override
	public Profesor insertarProfesor(Profesor profesor) {
		if (profesor!=null && getProfesorByName(profesor.getNombre())==null) {
			Profesor profesors = profesorRepo.save(profesor);
			return profesors;
		}
		
		return null;
	}

	@Override
	public Profesor getProfesorByName(String nombre) {
		if (nombre!=null) {
			
			Profesor prof = profesorRepo.findByNombre(nombre);
			
			return prof; 			
		}
		
		return null;
	}

	@Override
	public List<Profesor> findByDepartamento(Long departamento) {
		
		//	//Obtengo el resultado a través del repositorio
		List<Profesor> profesores = profesorRepo.findAll();	
		List<Profesor> profesorByDepartamento=new ArrayList<>();
		
		for (Profesor profesor : profesores) {
			if(profesor.getDepartamento().getId().equals(departamento))
			{
				profesorByDepartamento.add(profesor);
			}
		}
		
		return profesorByDepartamento;
		
	
	}

	@Override
	public Optional<Profesor> findDepartamentoById(Long id) {
		Optional<Profesor> profesor = null;
		
		if (id!=null) {
			profesor = profesorRepo.findById(id);
		}
		
		return profesor;
	}

	

}
