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

import com.indra.Biblioteca.model.Multa;
import com.indra.Biblioteca.service.MultaService;

@Controller
public class MultaController {
	@Autowired
	private MultaService multaService;
	
	
	@GetMapping("/Multa")
	public String viewHomePage(Model model) {
		return findPaginatedMulta(1, "fIncio", "asc", model);
	}
	
	
	@GetMapping("/addMulta")
	public String showNewCourseForm(Model model) {
		Multa multa = new Multa();
		model.addAttribute("multa", multa);
		return "new_Multa";
	}

	@PostMapping("/saveMulta")
	public String saveMulta(@ModelAttribute("multa") Multa multa) {
		// save Multa to database
		multaService.saveMulta(multa);
		return "redirect:/Multa";
	}

	@GetMapping("/updateMulta/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		Multa multa = multaService.getMultaById(id);
		model.addAttribute("multa", multa);
		return "update_Multa";
	}

	@GetMapping("/deleteMulta/{id}")
	public String deleteMulta(@PathVariable(value = "id") long id) {

		this.multaService.deleteMultaById(id);
		return "redirect:/Multa";
	}
	
	
	@GetMapping("/pageMulta/{pageNoMulta}")
	public String findPaginatedMulta(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 4;

		Page<Multa> page = multaService.findPaginatedMulta(pageNo, pageSize, sortField, sortDir);
		List<Multa> listMulta = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listMulta", listMulta);
		return "index_Multa";
	}

}
