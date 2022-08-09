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
import com.indra.Biblioteca.service.AutorService;

/**
 * @author aocarballo
 *
 */
@Controller
public class AutorController {
	@Autowired
	private AutorService autorService;

	@GetMapping("/autor")
	public String viewHomePage(Model model) {
		return findPaginated(1, "nombre", "asc", model);
	}

	@GetMapping("/addautor")
	public String showNewAutorForm(Model model) {
		Autor Autor = new Autor();
		model.addAttribute("autor", Autor);
		return "new_autor";
	}

	@PostMapping("/saveautor")
	public String saveAutor(@ModelAttribute("autor") Autor autor) {
		// save Autor to database
		autorService.saveAutor(autor);
		return "redirect:/autor";
	}

	@GetMapping("/updateautor/{id}")
	public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {

		Autor autor = autorService.getAutorById(id);
		model.addAttribute("autor", autor);
		return "update_autor";
	}

	@GetMapping("/deleteautor/{id}")
	public String deleteAutor(@PathVariable (value = "id") long id) {

		this.autorService.deleteAutorById(id);
		return "redirect:/autor";
	}


	@GetMapping("/pageautor/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
								@RequestParam("sortField") String sortField,
								@RequestParam("sortDir") String sortDir,
								Model model) {
		int pageSize = 4;

		Page<Autor> page = autorService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Autor> listAutor = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listAutor", listAutor);
		return "indexautor";
	}
}
