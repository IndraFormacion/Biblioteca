package com.indra.Biblioteca.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.indra.Biblioteca.model.Copia;
import com.indra.Biblioteca.model.EstadoCopia;
import com.indra.Biblioteca.model.Lector;
import com.indra.Biblioteca.model.Libro;
import com.indra.Biblioteca.model.Prestamo;
import com.indra.Biblioteca.service.PrestamoService;
import com.indra.Biblioteca.service.LectorService;
import com.indra.Biblioteca.service.CopiaService;
import com.indra.Biblioteca.service.EstadoCopiaService;
import com.indra.Biblioteca.service.LibroService;

@Controller
public class PrestamoController {
	@Autowired
	private PrestamoService prestamoService;
	@Autowired
	private CopiaService copiaService;
	@Autowired
	private LectorService lectorService;
	@Autowired
	private LibroService libroService;
	@Autowired
	private EstadoCopiaService estadocopiaService;
	
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginatedPrestamo(1, "inicio", "asc", model);
	}
	
	
	@GetMapping("/addPrestamo")
	public String showNewCourseForm(Model model) {
		Prestamo prestamo = new Prestamo();
		model.addAttribute("prestamo", prestamo);
		List<Copia> copias = copiaService.getAllCopia();
		model.addAttribute("copias", copias);
		List<Libro> libros = libroService.getAllLibros();
		model.addAttribute("libros", libros);
		List<Lector> lector = lectorService.getAllLectores();
		model.addAttribute("lector", lector);
		return "new_prestamo";
	}

	@PostMapping("/savePrestamo/")
	public String savePrestamo(@ModelAttribute("prestamo") Prestamo prestamo) {
		// save Prestamo to database
		
		Copia copia = prestamo.getCopia();
		EstadoCopia estcopia = estadocopiaService.getCopiaById(2);
		Copia copias = copiaService.getCopiaById(copia.getId());
		
		Libro libro = copias.getLibro();
		copia.setLibro(libro);
		copia.setEstadoCopia(estcopia);
		copiaService.saveCopia(copia);
		
		prestamoService.savePrestamo(prestamo);
		return "redirect:/";
	}

	@GetMapping("/updatePrestamo/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		Prestamo prestamo = prestamoService.getPrestamoById(id);
		model.addAttribute("prestamo", prestamo);
		List<Copia> copias = copiaService.getAllCopia();
		model.addAttribute("copias", copias);
		List<Libro> libros = libroService.getAllLibros();
		model.addAttribute("libros", libros);
		List<Lector> lector = lectorService.getAllLectores();
		model.addAttribute("lector", lector);
		return "update_prestamo";
	}

	@GetMapping("/deletePrestamo/{id}")
	public String deleteMulta(@PathVariable(value = "id") long id) {

		Prestamo prestamo = prestamoService.getPrestamoById(id);

		Copia copia = prestamo.getCopia();
		EstadoCopia estcopia = estadocopiaService.getCopiaById(3);
		copia.setEstadoCopia(estcopia);
		copia.setLibro(copia.getLibro());
		copiaService.saveCopia(copia);
		
		this.prestamoService.deletePrestamoById(id);
		
		
		return "redirect:/";
	}
	
	
	@GetMapping("/pagePrestamo/{pageNo}")
	public String findPaginatedPrestamo(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 4;

		Page<Prestamo> page = prestamoService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Prestamo> listPrestamo = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listPrestamo", listPrestamo);

		List<Copia> copias = copiaService.getAllCopia();
		model.addAttribute("copias", copias);
		List<Libro> libros = libroService.getAllLibros();
		model.addAttribute("libros", libros);
		List<Lector> lector = lectorService.getAllLectores();
		model.addAttribute("lector", lector);
		return "indexprestamo";
	}

}
