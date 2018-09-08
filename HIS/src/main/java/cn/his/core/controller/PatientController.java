package cn.his.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.his.core.model.doctor.Department;
import cn.his.core.model.patient.Medical_record;
import cn.his.core.model.patient.Patient;
import cn.his.core.service.doctor.DepartmentService;
import cn.his.core.service.patient.Medical_recordService;
import cn.his.core.service.patient.PatientService;

@Controller
public class PatientController {
	
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private Medical_recordService medical_recordService;

	/**
	 * 去挂号
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toRegister.action")
	public String toRegister(ModelMap model) {
		List<Department> departments = departmentService.findDepartmentList(new Department());
		model.addAttribute("departments", departments);
		return "registered";
	}
	
	/**
	 * 挂号
	 * @param patient
	 * @param department_code
	 * @return
	 */
	@RequestMapping(value = "/regist.action")
	public String Register(Patient patient, String department_code, ModelMap model) {
		patientService.insertPatient(patient);
		model.addAttribute("msg", "挂号成功");
		model.addAttribute("code", "success");
		model.addAttribute("url", "/HIS/toRegister.action");
		model.addAttribute("urlname", "挂号系统");
		model.addAttribute("time", 3);
		return "message";
	}
}
