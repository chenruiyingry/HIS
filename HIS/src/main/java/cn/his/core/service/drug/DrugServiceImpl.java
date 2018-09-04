package cn.his.core.service.drug;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.his.common.page.Pagination;
import cn.his.core.dao.drug.DrugDao;
import cn.his.core.model.drug.Drug;

@Service
@Transactional
public class DrugServiceImpl implements DrugService {

	@Resource
	private DrugDao drugDao;
	
	@Transactional(readOnly = true)
	@Override
	public Pagination findDrugList(Drug drug) {
		Pagination pagination = new Pagination(drug.getPageNo(), drug.getPageSize(), drugDao.getDrugCount(drug));
		List<Drug> drugs = drugDao.findDrugList(drug);
		pagination.setList(drugs);
		return pagination;
	}

	@Transactional(readOnly = true)
	@Override
	public Drug findDrugByCode(String code) {
		return drugDao.findDrugByCode(code);
	}

	@Override
	public int getDrugCount(Drug drug) {
		return drugDao.getDrugCount(drug);
	}

	@Override
	public boolean insertDrug(Drug drug) {
		List<Drug> list = drugDao.findDrugList(new Drug());
		Drug drug2 = list.get(1);
		String code = Integer.toString(Integer.parseInt(drug2.getCode()) + 1);
		System.out.println(code);
		return drugDao.insertDrug(drug);
	}

	@Override
	public boolean updateDrug(Drug drug) {
		return drugDao.updateDrug(drug);
	}

	@Override
	public boolean deleteDrug(String code) {
		return drugDao.deleteDrug(code);
	}

}
