package cn.his.core.service.drug;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.his.common.page.Pagination;
import cn.his.core.dao.drug.DrugDao;
import cn.his.core.dao.drug.Drug_recordDao;
import cn.his.core.model.drug.Drug;
import cn.his.core.model.drug.Drug_record;

@Service
@Transactional
public class Drug_recordServiceImpl implements Drug_recordService {
	
	@Resource
	private Drug_recordDao drug_recordDao;
	
	@Resource
	private DrugDao drugDao;

	@Transactional(readOnly = true)
	@Override
	public Pagination findDrug_recordList(Drug_record drug_record) {
		Pagination pagination = new Pagination(drug_record.getPageNo(), drug_record.getPageSize(), drug_recordDao.getDrug_recordCountByMedical_code(drug_record));
		List<Drug_record> drug_records = drug_recordDao.findDrug_recordList(drug_record);
		for (Drug_record drug_record2 : drug_records) {
			Drug drug = drugDao.findDrugByCode(drug_record2.getDrug_code());
			drug_record2.setDrug(drug);
		}
		pagination.setList(drug_records);
		return pagination;
	}

	@Transactional(readOnly = true)
	@Override
	public Drug_record findDrug_recordByCode(String code) {
		Drug_record drug_record = drug_recordDao.findDrug_recordByCode(code);
		Drug drug = drugDao.findDrugByCode(drug_record.getDrug_code());
		drug_record.setDrug(drug);
		return drug_record;
	}

	@Override
	public boolean insertDrug_record(Drug_record drug_record) {
		List<Drug_record> drug_records = drug_recordDao.findDrug_recordList(new Drug_record());
		int num = Integer.parseInt(drug_records.get(drug_records.size() - 1).getCode()) + 1;
		drug_record.setCode(Integer.toString(num));
		return drug_recordDao.insertDrug_record(drug_record);
	}

	@Override
	public boolean updateDrug_record(Drug_record drug_record) {
		return drug_recordDao.updateDrug_record(drug_record);
	}

	@Override
	public boolean deleteDrug_record(String code) {
		return drug_recordDao.deleteDrug_record(code);
	}

}
