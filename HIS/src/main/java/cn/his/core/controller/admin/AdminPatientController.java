package cn.his.core.controller.admin;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.his.common.page.Pagination;
import cn.his.core.model.patient.Patient;
import cn.his.core.service.patient.PatientService;

/**
 * 后台病人模块
 * @author chenruiying
 *
 */
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
	public String patientList(ModelMap model, Integer pageNo, String name, String title, String msg, String status) {
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
		model.addAttribute("title", title);
		model.addAttribute("msg", msg);
		model.addAttribute("status", status);
		return "patient_s";
	}
	
	/**
	 * 病人详细信息
	 * @param code
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/patient.do")
	public String patient(String code, String title, String msg, String status, ModelMap model) {
		Patient patient = patientService.findPatientByCode(code);
		model.addAttribute("patient", patient);
		model.addAttribute("title", title);
		model.addAttribute("msg", msg);
		model.addAttribute("status", status);
		return "patient_i";
	}
	
	/**
	 * 删除病人
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/admin/deletePatient.do")
	public String deletePatient(String code, ModelMap model) {
		patientService.deletePatient(code);
		model.addAttribute("title", "操作成功");
		model.addAttribute("msg", "删除病人成功！");
		model.addAttribute("status", "success");
		return "redirect:/admin/patientList.do";
	}
	
	/**
	 * 修改病人信息
	 * @param patient
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/editPatient.do", method = RequestMethod.POST)
	public String editPatient(Patient patient, ModelMap model) {
		model.addAttribute("code", patient.getCode());
		if (patient.getName() == "" || patient.getSex() == "" || patient.getAge() == 0 || patient.getPhone() ==  "" || 
				patient.getInsurance_type() == "" ) {
			model.addAttribute("title", "操作失败");
			model.addAttribute("msg", "请填写完整表单信息！");
			model.addAttribute("status", "error");
			model.addAttribute("patient", patient);
		} else {
			model.addAttribute("title", "操作成功");
			model.addAttribute("msg", "修改病人信息成功！");
			model.addAttribute("status", "success");
			patientService.updatePatient(patient);
		}
		return "redirect:/admin/patient.do";
	}
}
