package com.Abhi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Abhi.entities.CitizenPlans;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlans, Integer> {
	
	@Query(value = "select distinct(planName) from CitizenPlans")
	List<String> getPlanNames();
	
	@Query(value = "select distinct(planStatus) from CitizenPlans")
	List<String> getStatusNames();

}
