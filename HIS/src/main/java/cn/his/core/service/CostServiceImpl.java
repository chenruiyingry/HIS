package cn.his.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.his.core.dao.CostDao;
import cn.his.core.model.Cost;

@Service
@Transactional
public class CostServiceImpl implements CostService {

	@Resource
	private CostDao costdao;
	
	public List<Cost> findCostByMedical_code(String medical_code) {
		// TODO Auto-generated method stub
		return costdao.findCostByMedical_code(medical_code);
	}

	public Cost findCostByCode(String code) {
		// TODO Auto-generated method stub
		return costdao.findCostByCode(code);
	}

	public int getCostCount(Cost cost) {
		// TODO Auto-generated method stub
		return costdao.getCostCount(cost);
	}

	public List<Cost> findCostList(Cost cost) {
		// TODO Auto-generated method stub
		return costdao.findCostList(cost);
	}

	public boolean insertCost(Cost cost) {
		// TODO Auto-generated method stub
		return costdao.insertCost(cost);
	}

	public boolean updateCost(Cost cost) {
		// TODO Auto-generated method stub
		return costdao.updateCost(cost);
	}

	public boolean deleteAll(String code) {
		// TODO Auto-generated method stub
		return costdao.deleteAll(code);
	}

}
