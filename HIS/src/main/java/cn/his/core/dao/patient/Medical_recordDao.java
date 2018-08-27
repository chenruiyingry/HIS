package cn.his.core.dao.patient;

import java.util.List;

import cn.his.core.model.patient.Medical_record;
import cn.his.core.model.patient.Patient;

public interface Medical_recordDao {
	
	
	
	/**
	 * 通过病人或医生编号查询所有病历信息
	 * @param medical_record
	 * @return
	 */
	public List<Medical_record> findMedical_recordList(Medical_record medical_record);
	
	/**
	 * 查询同一个病人编号的病历的总记录数
	 * @param code
	 * @return
	 */
	public int getMedical_recordCount(String code);
	
	/**
	 * 通过病历号查询所有信息
	 * @param code
	 * @return
	 */
	public Medical_record findMedical_recordByCode(String code);
	
	/**
	 * 添加新的病历信息 
	 * @param medical_record
	 * @return
	 */
	public boolean insertMedical_record(Medical_record medical_record);
	
	/**
	 * 修改病历信息
	 * @param medical_record
	 * @return
	 */
	public boolean updateMdical_record(Medical_record medical_record);
	
	/**
	 * 删除病历信息
	 * @param code
	 * @return
	 */
	public boolean deleteMedical_record(String code);
}
