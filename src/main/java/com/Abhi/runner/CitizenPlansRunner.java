package com.Abhi.runner;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.Abhi.entities.CitizenPlans;
import com.Abhi.repositories.CitizenPlanRepository;

@Component
public class CitizenPlansRunner implements ApplicationRunner {
	
	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		 repo.deleteAll();
		//cash plan
		CitizenPlans c1 = new CitizenPlans();
		c1.setCitizenName("John");
		c1.setCitizenGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmount(6000.0);
		
		CitizenPlans c2 = new CitizenPlans();
		c2.setCitizenName("Stever");
		c2.setCitizenGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setDenialReason("No Income");
		
		CitizenPlans c3 = new CitizenPlans();
		c3.setCitizenName("Cathy");
		c3.setCitizenGender("Female");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(2));
		c3.setPlanEndDate(LocalDate.now().plusMonths(4));
		c3.setBenefitAmount(5000.0);
		c3.setTermiantedDate(LocalDate.now());
		c3.setTerminationReason("Employed");
		
		//food plan
		CitizenPlans c4 = new CitizenPlans();
		c4.setCitizenName("David");
		c4.setCitizenGender("Male");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenefitAmount(6000.0);
		
		CitizenPlans c5 = new CitizenPlans();
		c5.setCitizenName("Ceaser");
		c5.setCitizenGender("Male");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
		c5.setDenialReason("No Income");
		
		CitizenPlans c6 = new CitizenPlans();
		c6.setCitizenName("Jasmine");
		c6.setCitizenGender("Female");
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(2));
		c6.setPlanEndDate(LocalDate.now().plusMonths(4));
		c6.setBenefitAmount(5000.0);
		c6.setTermiantedDate(LocalDate.now());
		c6.setTerminationReason("Employed");
		
		CitizenPlans c7 = new CitizenPlans();
		c7.setCitizenName("Charles");
		c7.setCitizenGender("Male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenefitAmount(6000.0);
		
		CitizenPlans c8 = new CitizenPlans();
		c8.setCitizenName("Miller");
		c8.setCitizenGender("Male");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denied");
		c8.setDenialReason("No Income");
		
		CitizenPlans c9 = new CitizenPlans();
		c9.setCitizenName("Jasmine");
		c9.setCitizenGender("Female");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().minusMonths(2));
		c9.setPlanEndDate(LocalDate.now().plusMonths(4));
		c9.setBenefitAmount(5000.0);
		c9.setTermiantedDate(LocalDate.now());
		c9.setTerminationReason("Employed");
		
		CitizenPlans c10 = new CitizenPlans();
		c10.setCitizenName("Ben");
		c10.setCitizenGender("Male");
		c10.setPlanName("Employment");
		c10.setPlanStatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setBenefitAmount(6000.0);
		
		CitizenPlans c11 = new CitizenPlans();
		c11.setCitizenName("Rhodey");
		c11.setCitizenGender("Male");
		c11.setPlanName("Employment");
		c11.setPlanStatus("Denied");
		c11.setDenialReason("No Income");
		
		CitizenPlans c12 = new CitizenPlans();
		c12.setCitizenName("Priya");
		c12.setCitizenGender("Female");
		c12.setPlanName("Employment");
		c12.setPlanStatus("Terminated");
		c12.setPlanStartDate(LocalDate.now().minusMonths(2));
		c12.setPlanEndDate(LocalDate.now().plusMonths(4));
		c12.setBenefitAmount(5000.0);
		c12.setTermiantedDate(LocalDate.now());
		c12.setTerminationReason("Employed");
		
		
		repo.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12));
		
		

	}

}
