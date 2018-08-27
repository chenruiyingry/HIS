package cn.his.core.dao.drug;

import java.util.List;

import cn.his.core.model.drug.Drug_record;

public interface Drug_recordDao {

	/**
	 * 通过病历编号查询药品单列表，带分页 根据状态查询药品信息 根据药品编码查询
	 * @return
	 */
	public List<Drug_record> findDrug_recordList(Drug_record drug_record); 
	
	/**
	 * 通过病历编号查询药品单数量，带分页 根据状态查询药品信息 根据药品编码查询
	 * @param drug_record
	 * @return
	 */
	public int getDrug_recordCountByMedical_code(Drug_record drug_record);
	
	/**
	 * 通过药单编号查询药单信息
	 * @return
	 */
	public Drug_record findDrug_recordByCode(String code);
	
	/**
	 * 新增药单
	 * @param drug_record
	 * @return
	 */
	public boolean insertDrug_record(Drug_record drug_record);
	
	/**
	 * 修改药单
	 * @param drug_record
	 * @return
	 */
	public boolean updateDrug_record(Drug_record drug_record);
	
	/**
	 * 删除药单
	 * @param code
	 * @return
	 */
	public boolean deleteDrug_record(String code);
}
