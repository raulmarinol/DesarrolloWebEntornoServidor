package org.iesalixar.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.dto.DepartamentoDTO;
import org.iesalixar.servidor.model.Alumno;
import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.services.DepartamentoServiceImpl;
import org.iesalixar.servidor.services.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfesorController {

	@Autowired
	ProfesorServiceImpl profesorService;
	
	@Autowired
	DepartamentoServiceImpl departamentoService;
	
	@RequestMapping("/profesors")
	public String profesors(Model model) {
		
		List<Profesor> profesores = profesorService.getAllProfesors();
		
		model.addAttribute("contenido","Lista Profesores");
		model.addAttribute("teacher",profesores);
		return "profesors";
	}
	
	@GetMapping("/profesors/editProfesor")
	public String editDpto(@RequestParam(name="pr") String pr,Model model) {
		
		List<Departamento> depatamentolist = departamentoService.getAllDepartments();
		
		Profesor profesores = profesorService.findProfesorById(Long.parseLong(pr));
		
		model.addAttribute("depatamentolist", depatamentolist);
		model.addAttribute("teacher", profesores);
		return "editProfesor";
	}
	
	
	@PostMapping("/profesors/editProfesor")
	public String actualizarProfesor(@ModelAttribute Profesor pr) {
		
		if (profesorService.actualizarProfesor(pr)==null) {
			return "redirect:/profesors/edit?error=error&pr"+pr.getId();
		}
		return "redirect:/profesors";
	}
	
	@GetMapping("/profesors/addProfesor")
	public String addProfesorGet(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="prof") String nombre,
			Model model) {
		
		Profesor prof = new Profesor();
		List<Departamento> depatamentolist = departamentoService.getAllDepartments();
		
		model.addAttribute("depatamentolist", depatamentolist);
		model.addAttribute("prof", prof);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		return "addProfesor";
	}
	
	
	@PostMapping("/profesors/addProfesor")
	public String addProfesorPost(@ModelAttribute Profesor prof,Model model) {
		
		Departamento profe = new Departamento();
		profe.setNombre(prof.getNombre());
		
		if (profesorService.insertarProfesor(prof)==null) {
			return "redirect:/departments/add?error=Existe&dpto="+prof.getNombre();
		}
		
		return "redirect:/profesors";
	}
	
	@GetMapping("/profesors/buscarProDepartamento")
	public String buscarPro(@RequestParam(required=false,name="error") String error,
			@RequestParam(required=false,name="dpto") String nombre,@RequestParam(required=false,name="dpto") String dpto,
			Model model) {		


		List<Profesor> profesores = profesorService.findByDepartamento(Long.parseLong(dpto));
		
		model.addAttribute("profesores", profesores);
		model.addAttribute("error", error);
		model.addAttribute("previo", nombre);
		return "buscarProDepartamento";
	}
	

}
