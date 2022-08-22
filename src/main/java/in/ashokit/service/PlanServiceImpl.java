package in.ashokit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Plan;
import in.ashokit.entity.PlanCategory;
import in.ashokit.repo.PlanCategoryRepo;
import in.ashokit.repo.PlanRepo;

@Service
public class PlanServiceImpl implements IPlanService {

	@Autowired
	private PlanRepo planRepo;
	@Autowired
	private PlanCategoryRepo planCategoryRepo;

	@Override
	public Map<Integer, String> getPlanCategories() {
		List<PlanCategory> categories = planCategoryRepo.findAll();
		Map<Integer, String> categoryMap = new HashMap<>();

		categories.forEach(category -> {
			categoryMap.put(category.getCategoryId(), category.getCategoryName());
		});
		return categoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		return planRepo.save(plan).getPlanId() != null;

	}

	@Override
	public boolean deletePlanById(Integer planId) {
		if (planId != null) {
			planRepo.deleteById(planId);
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		if (plan.getPlanId() != null) {
			planRepo.save(plan);
			return true;
		}
		return false;

	}

	@Override
	public List<Plan> getAllPlan() {

		return planRepo.findAll();
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> opt = planRepo.findById(planId);
		return opt.get();
	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {
		Optional<Plan> findById = planRepo.findById(planId);
		if (findById.isPresent()) {
			Plan plan = findById.get();
			plan.setActiveSw(status);
			plan.setPlanId(planId);
			planRepo.save(plan);
			return true;
		}
		return false;
	}

}
