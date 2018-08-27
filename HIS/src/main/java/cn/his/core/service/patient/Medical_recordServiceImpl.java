package cn.his.core.service.patient;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.his.common.page.Pagination;
import cn.his.core.dao.drug.Drug_recordDao;
import cn.his.core.dao.patient.Medical_recordDao;
import cn.his.core.model.drug.Drug_record;
import cn.his.core.model.patient.Medical_record;

@Service
@Transactional
public class Medical_recordServiceImpl implements Medical_recordService{
	
	@Resource
	private Medical_recordDao medical_recordDao;
	
	@Resource
	private Drug_recordDao drug_recordDao;

	@Transactional(readOnly = true)
	public Pagination findMedical_recordList(Medical_record medical_record) {
		Pagination pagination = new Pagination(medical_record.getPageNo(), medical_record.getPageSize(), medical_recordDao.getMedical_recordCount(medical_record.getPatient_code()));
		List<Medical_record> medical_records = medical_recordDao.findMedical_recordList(medical_record);
		Drug_record drug_record = new Drug_record();
		for (Medical_record medical_record2 : medical_records) {
			drug_record.setMedical_code(medical_record2.getCode());
			List<Drug_record> drug_records = drug_recordDao.findDrug_recordList(drug_record);
			if (drug_records.size() > 0) {
				medical_record2.setDrug_record(drug_records);
			}
		}
		pagination.setList(medical_records);
		return pagination;
	}

	@Transactional(readOnly = true)
	public int getMedical_recordCount(String code) {
		return medical_recordDao.getMedical_recordCount(code);
	}

	@Transactional(readOnly = true)
	public Medical_record findMedical_recordByCode(String code) {
		Medical_record medical_record = medical_recordDao.findMedical_recordByCode(code);
		Drug_record drug_record = new Drug_record();
		drug_record.setMedical_code(medical_record.getCode());
		List<Drug_record> drug_records = drug_recordDao.findDrug_recordList(drug_record);
		medical_record.setDrug_record(drug_records);
		return medical_record;
	}

	public boolean insertMedical_record(Medical_record medical_record) {
		return medical_recordDao.insertMedical_record(medical_record);
	}

	public boolean updateMedical_record(Medical_record medical_record) {
		return medical_recordDao.updateMdical_record(medical_record);
	}

	public boolean deleteMedical_record(String code) {
		return medical_recordDao.deleteMedical_record(code);
	}


}
