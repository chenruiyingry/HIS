package cn.his.core.service.doctor;

import cn.his.common.page.Pagination;
import cn.his.core.model.doctor.Doctor;

public interface DoctorService {
	
	/**
	 * 查询医生集合
	 * @param dinformation
	 * @return
	 */
	public Pagination findDoctorListWithPage(Doctor doctor);
	
	/**
	 * 通过医生编号查找医生信息
	 * @param dcode
	 * @return
	 */
	public Doctor findDoctorByCode(String code);

	/**
	 * 添加医生
	 * @param dinformation
	 */
	public boolean insertDoctor(Doctor doctor);
	
	/**
	 * 删除医生信息
	 * @param dcode
	 */
	public boolean deleteDoctorByCode(String code);
	
	/**
	 * 更新医生信息
	 * @param dinformation
	 */
	public boolean updateDoctor(Doctor doctor);
}
