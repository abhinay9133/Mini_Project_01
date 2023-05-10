package com.Abhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Abhi.entities.CitizenPlans;
import com.Abhi.request.SearchRequest;
import com.Abhi.service.ReportService;

@Controller
public class ReportController {

	@Autowired

	private ReportService service;

	@GetMapping("/")
	public String loadData(Model model) {
		model.addAttribute("search",new SearchRequest());
		init(model);
		return "index";
	}
	private void init(Model model) {
		model.addAttribute("plannames",service.fetchPlanNames());
		model.addAttribute("status", service.fetchPlanStatus());
	}
	@PostMapping("/plan")
	public String handleSearch(@ModelAttribute("search")SearchRequest search ,Model model) {
		List<CitizenPlans> plans = service.fetchPlans(search);
		init(model);
		model.addAttribute("plans", plans);
		return "index";
	}
	@GetMapping("/excel")
	public String exportExcel(@ModelAttribute("search")SearchRequest search ,Model model) {
		boolean status = service.exportEmail();
		init(model);
		if(status) {
			model.addAttribute("export","Excel Exported");
		}else {
			model.addAttribute("export","Excel not Exported");
		}
		return "index";	
	}
	@GetMapping("/pdf")
	public String exportGenerate(@ModelAttribute("search")SearchRequest search ,Model model) {
		boolean status = service.exportPDF();
		init(model);
		if(status) {
			model.addAttribute("export","Pdf Exported");
		}else {
			model.addAttribute("export","Pdf not Exported");
		}
		return "index";	
	} 
}
