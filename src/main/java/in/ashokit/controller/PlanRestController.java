package in.ashokit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Plan;
import in.ashokit.service.IPlanService;

@RestController
public class PlanRestController {

	@Autowired
	private IPlanService service;

	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> showCategories() {
		Map<Integer, String> categories = service.getPlanCategories();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
		String responseMsg = "";
		boolean isSaved = service.savePlan(plan);
		if (isSaved) {
			responseMsg = "Plan saved";
		} else {
			responseMsg = "plan not saved";
		}
		return new ResponseEntity<>(responseMsg, HttpStatus.CREATED);
	}

	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
		String msg = "";
		boolean isDeleted = service.deletePlanById(planId);
		if (isDeleted) {
			msg = "Plan " + planId + " deleted";
		} else {
			msg = "Plan " + planId + " not present";
		}

		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> showPlans() {
		List<Plan> plan = service.getAllPlan();
		return new ResponseEntity<>(plan, HttpStatus.OK);
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
		Plan plan=service.getPlanById(planId);
		return new ResponseEntity<>(plan,HttpStatus.OK);
	}
	
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan){
		String msg="";
		 boolean isUpdated= service.updatePlan(plan);
		 if(isUpdated) {
			 msg="plan updated";
		 }else {
			 msg="Plan not updated";
		 }
		  
		  return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> changeStatus(@PathVariable Integer planId, String status){
		String msg="";
		boolean isStatusChanged=service.planStatusChange(planId, status);
		if(isStatusChanged) {
			msg="Status changed";
		}else {
			msg="status not changed";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
