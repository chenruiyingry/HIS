package cn.his.core.service.doctor;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.his.core.dao.doctor.DepartmentDao;
import cn.his.core.dao.doctor.DoctorDao;
import cn.his.core.model.doctor.Department;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Resource
	private DepartmentDao departmentDao;
	
	@Resource
	private DoctorDao doctorDao;

	@Transactional(readOnly = true)
	@Override
	public List<Department> findDepartmentList(Department department) {	
		return departmentDao.findDepartmentList(department);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Department> findDivisionList() {
		List<Department> list = departmentDao.findDivisionList();
		for (Department department : list) {
			Department department2 = new Department();
			department2.setP_code(department.getP_code());
			int departmentcount = departmentDao.getDepartmentCount(department2);
			department.setDepartmentnum(departmentcount);
		}
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Department> findDepartmentListByP_code(String p_code) {
		List<Department> list = departmentDao.findDepartmentListByP_code(p_code);
		for (Department department2 : list) {
			int doctornum = doctorDao.getDoctorCountByDepartment(department2.getCode());
			department2.setDoctornum(doctornum);
		}
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public Department findDepartmentByCode(String code) {
		return departmentDao.findDepartmentByCode(code);
	}

	@Transactional(readOnly = true)
	@Override
	public Department findDivisionByCode(String code) {
		return departmentDao.findDivisionByCode(code);
	}

	@Transactional(readOnly = true)
	@Override
	public int getDivisionCount(Department department) {
		return departmentDao.getDivisionCount(department);
	}

	@Transactional(readOnly = true)
	@Override
	public int getDepartmentCount(Department department) {
		return departmentDao.getDepartmentCount(department);
	}

	@Override
	public boolean insertDepartment(Department department) {
		//部门
		if (department.getP_code() == null) {
			List<Department> division = departmentDao.findDivisionList();
			int num = Integer.parseInt(division.get(division.size() - 1).getP_code()) + 100;
			department.setP_code(Integer.toString(num));
		} 
		//科室
		else {
			List<Department> departments = departmentDao.findDepartmentListByP_code(department.getP_code());
			if (departments.size() > 0) {
				int num = Integer.parseInt(departments.get(departments.size() - 1).getCode())  + 1;
				department.setCode(Integer.toString(num));
			} else {
				int num = Integer.parseInt(department.getP_code())  + 1;
				department.setCode(Integer.toString(num));
			}
			
		}
		return departmentDao.insertDepartment(department);
	}

	@Override
	public boolean updateDepartment(Department department) {
		return departmentDao.updateDepartment(department);
	}

	@Override
	public boolean deleteDepartment(Integer id) {
		return departmentDao.deleteDepartment(id);
	}

	@Override
	public Department findDepartmentById(int id) {
		return departmentDao.findDepartmentById(id);
	}
	

}
