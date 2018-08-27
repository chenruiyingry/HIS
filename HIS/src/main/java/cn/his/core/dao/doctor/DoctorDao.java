package cn.his.core.dao.doctor;

import java.util.List;

import cn.his.core.model.doctor.Doctor;

public interface DoctorDao {
	
	/**
	 * 带分页的医生信息列表查询
	 * @param dinformationQuery
	 * @return
	 */
	public List<Doctor> findDoctorListWithPage(Doctor doctor);
	
	/**
	 * 查询医生数量
	 * @param dinformation
	 * @return
	 */
	public int getDoctorCount(Doctor doctor);
	
	/**
	 * 通过医生编号查找医生信息
	 * @param dcode
	 * @return
	 */
	public Doctor findDoctorByCode(String code);

	/**
	 * 添加医生
	 * @param dinformation
	 * @return TODO
	 */
	public boolean insertDoctor(Doctor doctor);
	
	/**
	 * 更新医生信息
	 * @param dinformation
	 * @return TODO
	 */
	public boolean updateDoctor(Doctor doctor);
	
	/**
	 * 通过医生代码删除医生信息
	 * @param dcode
	 * @return TODO
	 */
	public boolean deleteDoctorByCode(String code);
}
