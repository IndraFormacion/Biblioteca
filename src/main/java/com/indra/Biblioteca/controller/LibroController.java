/**
 * 
 */
package com.indra.Biblioteca.controller;

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

import com.indra.Biblioteca.model.Autor;
import com.indra.Biblioteca.model.Libro;
import com.indra.Biblioteca.model.TipoLibro;
import com.indra.Biblioteca.service.AutorService;
import com.indra.Biblioteca.service.LibroService;
import com.indra.Biblioteca.service.TipoLibroService;

/**
 * @author aocarballo
 *
 */
@Controller
public class LibroController {
	@Autowired
	private LibroService libroService;
	@Autowired
	private TipoLibroService tipoLibroService;
	@Autowired
	private AutorService autorService;

	@GetMapping("/libro")
	public String viewHomePage(Model model) {
		return findPaginated(1, "titulo", "asc", model);
	}

	@GetMapping("/addlibro")
	public String showNewLibroForm(Model model) {
		Libro Libro = new Libro();
		model.addAttribute("libro", Libro);
		List<TipoLibro> tipoLibroList = tipoLibroService.getAllTipoLibro();
		model.addAttribute("tipoLibroList", tipoLibroList);
		List<Autor> autorList = autorService.getAllAutor();
		model.addAttribute("autorList", autorList);
		return "new_libro";
	}

	@PostMapping("/savelibro")
	public String saveLibro(@ModelAttribute("libro") Libro libro) {
		// save Libro to database
		libroService.saveLibro(libro);
		return "redirect:/libro";
	}

	@GetMapping("/updatelibro/{id}")
	public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {

		Libro libro = libroService.getLibroById(id);
		model.addAttribute("libro", libro);
		List<TipoLibro> tipoLibroList = tipoLibroService.getAllTipoLibro();
		model.addAttribute("tipoLibroList", tipoLibroList);
		List<Autor> autorList = autorService.getAllAutor();
		model.addAttribute("autorList", autorList);
		return "update_libro";
	}

	@GetMapping("/deletelibro/{id}")
	public String deleteLibro(@PathVariable (value = "id") long id) {

		this.libroService.deleteLibroById(id);
		return "redirect:/libro";
	}


	@GetMapping("/pagelibro/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
								@RequestParam("sortField") String sortField,
								@RequestParam("sortDir") String sortDir,
								Model model) {
		int pageSize = 4;

		Page<Libro> page = libroService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Libro> listLibros = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listLibros", listLibros);
		return "indexlibro";
	}
}
