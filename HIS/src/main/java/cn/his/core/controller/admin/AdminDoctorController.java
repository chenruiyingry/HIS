package cn.his.core.controller.admin;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.his.common.page.Pagination;
import cn.his.core.model.doctor.Department;
import cn.his.core.model.doctor.Doctor;
import cn.his.core.service.doctor.DepartmentService;
import cn.his.core.service.doctor.DoctorService;

@Controller
public class AdminDoctorController {

	@Autowired
	private DoctorService doctorService;
	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * 医生列表
	 * @param model
	 * @param pageNo
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/admin/doctorList.do")
	public String doctorList(ModelMap model, Integer pageNo, String name) {
		Doctor doctor = new Doctor();
		StringBuilder params = new StringBuilder();
		if (StringUtils.isNotBlank(name)) {
			doctor.setName(name);
			params.append("name=").append(name);
		}
		doctor.setPageNo(Pagination.cpn(pageNo));
		doctor.setPageSize(7);
		Pagination pagination = doctorService.findDoctorListWithPage(doctor);	
		String url = "/HIS/admin/doctorList.do";
		pagination.pageView(url, params.toString());
		model.addAttribute("pagination", pagination);
		return "doctor_s";
	}
	
	@RequestMapping(value = "/admin/doctor.do")
	public String toDoctorInfo(String code, ModelMap model) throws ParseException {
		Doctor doctor = doctorService.findDoctorByCode(code);
		doctor.setDepartment(departmentService.findDepartmentByCode(doctor.getDepartment()).getName());
		if ("CHIEF".equals(doctor.getLevel())) {
			doctor.setLevel("主任医师");
		} else if ("ASSOCIATECHIEF".equals(doctor.getLevel())) {
			doctor.setLevel("副主任医师");
		} else if ("ATTENDING".equals(doctor.getLevel())) {
			doctor.setLevel("主治医师");
		} else if ("RESIDENT".equals(doctor.getLevel())) {
			doctor.setLevel("住院医师");
		} else if ("PHYSICIAN".equals(doctor.getLevel())) {
			doctor.setLevel("医师");
		} else if ("FELDSHER".equals(doctor.getLevel())) {
			doctor.setLevel("医士");
		} 
		if ("MAN".equals(doctor.getSex())) {
			doctor.setSex("男");
		} else if ("WOMAN".equals(doctor.getSex())) {
			doctor.setSex("女");
		}
		List<Department> list = departmentService.findDepartmentList(new Department());
		doctor.setWork_time(doctor.getWork_time().replace(" ", "T"));
		doctor.setOutwork_time(doctor.getOutwork_time().replace(" ", "T"));
		model.addAttribute("doctor", doctor);
		model.addAttribute("departmentlist", list);
		return "doctor_i";
	}
	
	@RequestMapping(value = "/admin/toAdd.do")
	public String toAddDoctor(ModelMap model) {
		model.addAttribute("code", "yesyes");
		List<Department> list = departmentService.findDepartmentList(new Department());
		model.addAttribute("departmentlist", list);
		return "doctor_i";
	}
}
