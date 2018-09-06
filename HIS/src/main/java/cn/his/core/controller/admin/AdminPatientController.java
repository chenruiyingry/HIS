package cn.his.core.controller.admin;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.his.common.page.Pagination;
import cn.his.core.model.doctor.Doctor;
import cn.his.core.model.patient.Patient;
import cn.his.core.service.patient.PatientService;

@Controller
public class AdminPatientController {
	
	@Autowired
	private PatientService patientService;
	
	/**
	 * 病人列表
	 * @param model
	 * @param pageNo
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/admin/patientList.do")
	public String patientList(ModelMap model, Integer pageNo, String name) {
		Patient patient = new Patient();
		StringBuilder params = new StringBuilder();
		if (StringUtils.isNotBlank(name)) {
			patient.setName(name);
			params.append("name=").append(name);
		}
		patient.setPageNo(Pagination.cpn(pageNo));
		patient.setPageSize(10);
		Pagination pagination = patientService.findPatientList(patient);
		String url = "/HIS/admin/patientList.do";
		pagination.pageView(url, params.toString());
		model.addAttribute("pagination", pagination);
		return "patient_s";
	}
	
	@RequestMapping(value = "/admin/patient.do")
	public String patient(String code, ModelMap model) {
		Patient patient = patientService.findPatientByCode(code);
		model.addAttribute("patient", patient);
		return "patient_i";
	}
	
	@RequestMapping(value = "/admin/deletePatient.do")
	public String deletePatient(String code) {
		patientService.deletePatient(code);
		return "redirect:/admin/patientList.do";
	}
}
