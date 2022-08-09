package com.indra.Biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import com.indra.Biblioteca.service.CopiaService;
import com.indra.Biblioteca.service.EstadoCopiaService;
import com.indra.Biblioteca.service.LibroService;
import com.indra.Biblioteca.model.Copia;
import com.indra.Biblioteca.model.EstadoCopia;
import com.indra.Biblioteca.model.Libro;

@Controller
public class CopiaController {


	@Autowired
	private CopiaService copiaService;
	
	@Autowired
	private EstadoCopiaService estadocopiaService;
	
	@Autowired
	private LibroService libroService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "estadoCopia", "asc", model);
	}
	@PostMapping("/saveCopy")
	public String saveCourse(@ModelAttribute("course") Copia copia) {
		// save Course to database
		copiaService.saveCopia(copia);
		return "redirect:/";
	}

	@GetMapping("/addcopy")
	public String showNewCourseForm(Model model) {
		Copia Copia = new Copia();
		model.addAttribute("copia", Copia);
		List<EstadoCopia> estcopia = estadocopiaService.getAllCopia();
		model.addAttribute("estcopia", estcopia);
		List<Libro> libros = libroService.getAllLibros();
		model.addAttribute("libros", libros);
		return "new_copy";
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
								@RequestParam("sortField") String sortField,
								@RequestParam("sortDir") String sortDir,
								Model model) {
		int pageSize = 4;

		Page<Copia> page = copiaService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Copia> listCourses = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listCourses", listCourses);
		return "indexcopy";
	}
}


 