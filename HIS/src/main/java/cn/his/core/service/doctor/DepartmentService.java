package cn.his.core.service.doctor;

import java.util.List;

import cn.his.core.model.doctor.Department;

public interface DepartmentService {
	
	/**
	 * 查询科室集合
	 * @param 
	 * @return
	 */
	public List<Department> findDepartmentList(Department department);
	
	/**
	 * 查询部门列表
	 * @return
	 */
	public List<Department> findDivisionList();
	
	/**
	 * 按部门查询科室列表
	 * @param department
	 * @return
	 */
	public List<Department> findDepartmentListByP_code(String p_code);
	
	/**
	 * 根据科室编号查询科室信息
	 * @param 
	 * @return
	 */
	public Department findDepartmentByCode(String code);
	
	/**
	 * 根据id查询科室信息
	 * @param id
	 * @return
	 */
	public Department findDepartmentById(int id);
	
	/**
	 * 根据部门编号查询部门信息
	 * @param code
	 * @return
	 */
	public Department findDivisionByCode(String code);

	/**
	 * 查询部门总数
	 * @param 
	 * @return
	 */
	public int getDivisionCount(Department department);
	
	/**
	 * 按部门查询科室总数
	 * @param department
	 * @return
	 */
	public int getDepartmentCount(Department department);
	
	/**
	 * 添加科室
	 * @param 
	 */
	public boolean insertDepartment(Department department);
	
	/**
	 * 更新科室信息
	 * @param 
	 */
	public boolean updateDepartment(Department department);
	
	/**
	 * 通过科室编号删除科室信息
	 * @param 
	 */
	public boolean deleteDepartment(Integer id);
}
