package cn.his.core.service.patient;

import java.util.List;

import cn.his.common.page.Pagination;
import cn.his.core.model.patient.Medical_record;
import cn.his.core.model.patient.Patient;

public interface PatientService {
	
	/**
	 * 通过病床号，查询病人信息
	 * @param bed_code
	 * @return
	 */
	public Patient findMedical_recordByCode(Medical_record medical_record);

	/**
	 * 通过医生编号获取病人列表，带分页
	 * @param code
	 * @return
	 */
	public Pagination findPatientList(Patient patient);
	
	/**
	 * 通过医生编号获取病人列表
	 * @param patient
	 * @return
	 */
	public List<Patient> findPatients(Patient patient);
	
	/**
	 * 获得对应医生病人数量
	 * @param code
	 * @return
	 */
	public int getPatientCount(String code);

	/**
	 * 通过病人编号获取病人信息
	 * @param code
	 * @return
	 */
	public Patient findPatientByCode(String code);
	
	/**
	 * 新增病人信息
	 * @param patient
	 */
	public boolean insertPatient(Patient patient);
	
	/**
	 * 更新病人信息
	 * @param patient
	 */
	public boolean updatePatient(Patient patient);
	
	/**
	 * 删除病人信息
	 * @param code
	 */
	public boolean deletePatient(String code);
}
