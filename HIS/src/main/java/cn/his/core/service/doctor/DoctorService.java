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
	 * 通过密码和医生编号查询
	 * @param code
	 * @param password
	 * @return
	 */
	public Doctor login(String code, String password);
	
	/**
	 * 查询部门医生数量
	 * @param code
	 * @return
	 */
	public int getDoctorCountByDepartment(String code);

	/**
	 * 添加医生
	 * @param dinformation
	 */
	public boolean insertDoctor(Doctor doctor);
	
	/**
	 * 删除医生信息
	 * @param dcode
	 */
	public boolean deleteDoctorByCode(int id);
	
	/**
	 * 更新医生信息
	 * @param dinformation
	 */
	public boolean updateDoctor(Doctor doctor);
}
