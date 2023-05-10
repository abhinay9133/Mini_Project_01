package com.Abhi.service;

import java.util.List;

import com.Abhi.entities.CitizenPlans;
import com.Abhi.request.SearchRequest;

public interface ReportService {
	
	List<CitizenPlans> fetchPlans(SearchRequest request);
	
	List<String> fetchPlanNames();
	
	List<String> fetchPlanStatus();
	
	boolean exportEmail();
	
	boolean exportPDF();

}
