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

	@Override
	public List<Department> findDepartmentList(Department department) {
		return departmentDao.findDepartmentList(department);
	}

	@Override
	public List<Department> findDivisionList() {
		return departmentDao.findDivisionList();
	}

	@Override
	public List<Department> findDepartmentListByP_code(String p_code) {
		return departmentDao.findDepartmentListByP_code(p_code);
	}

	@Override
	public Department findDepartmentByCode(String code) {
		return departmentDao.findDepartmentByCode(code);
	}

	@Override
	public Department findDivisionByCode(String code) {
		return departmentDao.findDivisionByCode(code);
	}

	@Override
	public int getDivisionCount(Department department) {
		return departmentDao.getDivisionCount(department);
	}

	@Override
	public int getDepartmentCount(Department department) {
		return departmentDao.getDepartmentCount(department);
	}

	@Override
	public boolean insertDepartment(Department department) {
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
	

}
