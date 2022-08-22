package in.ashokit.service;

import java.util.List;
import java.util.Map;

import in.ashokit.entity.Plan;

public interface IPlanService {
	
	public Map<Integer,String> getPlanCategories();
	
	public boolean savePlan(Plan plan);
	
	public boolean deletePlanById(Integer planId);
	
	public boolean updatePlan(Plan plan);
	
	public List<Plan> getAllPlan();
	
	public Plan getPlanById(Integer planId);
	
	public boolean planStatusChange(Integer planId,String status);

}
