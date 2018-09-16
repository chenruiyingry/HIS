package cn.his.core.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.his.core.model.doctor.Department;
import cn.his.core.service.doctor.DepartmentService;
import cn.his.core.service.doctor.DoctorService;

/**
 * 后台科室管理模块
 * @author chenruiying
 *
 */
@Controller
public class AdminDepartmentController {

	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private DoctorService doctorService;
	
	/**
	 * 部门列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/division.do")
	public String division(ModelMap model, String msg, String status, String title) {
		List<Department> list = departmentService.findDivisionList();
		model.addAttribute("list", list);
		model.addAttribute("msg", msg);
		model.addAttribute("status", status);
		model.addAttribute("title", title);
		return "department_a";
	}
	
	/**
	 * 某部门科室列表
	 * @param code
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/department.do")
	public String department(String code, ModelMap model, String msg, String status, String title) {
		List<Department> list = departmentService.findDepartmentListByP_code(code);
		model.addAttribute("list", list);
		model.addAttribute("p_code", code);
		model.addAttribute("msg", msg);
		model.addAttribute("status", status);
		model.addAttribute("title", title);
		return "department";
	}
	
	/**
	 * 新增部门
	 * @param department
	 * @return
	 */
	@RequestMapping(value = "/admin/addDivision.do", method = RequestMethod.POST)
	public String addDivision(Department department, ModelMap model) {
		if (department.getName() == "" || department.getIntroduction() == "") {
			model.addAttribute("title", "操作失败");
			model.addAttribute("msg", "请填写完整表单数据！");
			model.addAttribute("status", "error");
			return "redirect:/admin/division.do";
		} else {
			departmentService.insertDepartment(department);
			model.addAttribute("title", "操作成功");
			model.addAttribute("msg", "新增部门成功！");
			model.addAttribute("status", "success");
			return "redirect:/admin/division.do";
		}
		
	}
	
	/**
	 * 新增科室
	 * @param department
	 * @return
	 */
	@RequestMapping(value = "/admin/addDepartment.do", method = RequestMethod.POST)
	public String addDepartment(Department department, ModelMap model) {
		if (department.getName() == "" || department.getIntroduction() == "") {
			model.addAttribute("title", "操作失败");
			model.addAttribute("msg", "请填写完整表单数据！");
			model.addAttribute("status", "error");
			return "redirect:/admin/division.do";
		} else {
			departmentService.insertDepartment(department);
			model.addAttribute("title", "操作成功");
			model.addAttribute("msg", "新增科室成功！");
			model.addAttribute("status", "success");
			model.addAttribute("code", department.getP_code());
			return "redirect:/admin/department.do";
		}
	}
	
	/**
	 * 修改部门信息
	 * @param department
	 * @return
	 */
	@RequestMapping(value = "/admin/updateDepartment.do", method= RequestMethod.POST)
	public String updateDepartment(Department department, ModelMap model) {
		if (department.getName() == "" || department.getIntroduction() == "") {
			model.addAttribute("title", "操作失败");
			model.addAttribute("msg", "请填写完整表单数据！");
			model.addAttribute("status", "error");
			if (department.getCode() == null) {
				return "redirect:/admin/division.do";
			} else {
				model.addAttribute("code", department.getP_code());
				return "redirect:/admin/department.do";
			}
		} else {
			departmentService.updateDepartment(department);
			model.addAttribute("title", "操作成功");
			model.addAttribute("status", "success");
			if (department.getCode() == null) {
				model.addAttribute("msg", "部门信息修改成功！");
				return "redirect:/admin/division.do";
			} else {
				model.addAttribute("msg", "科室信息修改成功！");
				model.addAttribute("code", department.getP_code());
				return "redirect:/admin/department.do";
			}
		}
	}
	
	/**
	 * 删除部门
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/deleteDepartment.do")
	public String deleteDepartment(int id, ModelMap model) {
		Department department = departmentService.findDepartmentById(id);
		if (department.getCode() == null) {
			int departmentNumber = departmentService.getDepartmentCount(department);
			if (departmentNumber == 0) {
				departmentService.deleteDepartment(id);
				model.addAttribute("title", "操作成功");
				model.addAttribute("msg", "删除部门成功！");
				model.addAttribute("status", "success");
			} else {
				model.addAttribute("title", "操作失败");
				model.addAttribute("msg", "该部门还存在科室，不能删除！");
				model.addAttribute("status", "error");
			}
			return "redirect:/admin/division.do";
		} else {
			int doctorNumber = doctorService.getDoctorCountByDepartment(department.getCode());
			if (doctorNumber == 0) {
				model.addAttribute("title", "操作成功");
				model.addAttribute("msg", "删除科室成功！");
				model.addAttribute("status", "success");
				model.addAttribute("code", department.getP_code());
				departmentService.deleteDepartment(id);
			} else {
				model.addAttribute("title", "操作失败");
				model.addAttribute("msg", "该科室还有医生，不能删除！");
				model.addAttribute("status", "error");
				model.addAttribute("code", department.getP_code());
			}
		}
		return "redirect:/admin/department.do";
	}
}
