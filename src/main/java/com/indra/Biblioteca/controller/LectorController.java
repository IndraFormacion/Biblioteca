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

import com.indra.Biblioteca.model.Lector;
import com.indra.Biblioteca.service.LectorService;

@Controller
public class LectorController {
	@Autowired
	private LectorService lectorService;
	
	@GetMapping("/Lector")
	public String viewHomePage(Model model) {
		return findPaginatedLector(1, "nombre", "asc", model);
	}
	
	
	@GetMapping("/addLector")
	public String showNewCourseForm(Model model) {
		Lector lector = new Lector();
		model.addAttribute("lector", lector);
		return "new_Lector";
	}

	@PostMapping("/saveLector")
	public String saveLector(@ModelAttribute("lector") Lector lector) {
		// save Lector to database
		lectorService.saveLector(lector);
		return "redirect:/Lector";
	}

	@GetMapping("/updateLector/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		Lector lector = lectorService.getLectorById(id);
		model.addAttribute("lector", lector);
		return "update_Lector";
	}

	@GetMapping("/deleteLector/{id}")
	public String deleteLector(@PathVariable(value = "id") long id) {

		this.lectorService.deleteLectorById(id);
		return "redirect:/Lector";
	}
	
	
	
	@GetMapping("/pageLector/{pageNoLector}")
	public String findPaginatedLector(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 4;

		Page<Lector> page = lectorService.findPaginatedLector(pageNo, pageSize, sortField, sortDir);
		List<Lector> listLector = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listLector", listLector);
		return "index_Lector";
	}
}
