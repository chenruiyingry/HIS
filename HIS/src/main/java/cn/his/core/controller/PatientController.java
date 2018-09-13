package cn.his.core.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;

import cn.his.common.web.ResponseUtils;
import cn.his.common.web.SessionProvider;
import cn.his.core.model.Ward;
import cn.his.core.model.doctor.Department;
import cn.his.core.model.doctor.Doctor;
import cn.his.core.model.drug.Drug;
import cn.his.core.model.drug.Drug_record;
import cn.his.core.model.patient.Medical_record;
import cn.his.core.model.patient.Patient;
import cn.his.core.service.WardService;
import cn.his.core.service.doctor.DepartmentService;
import cn.his.core.service.drug.DrugService;
import cn.his.core.service.drug.Drug_recordService;
import cn.his.core.service.patient.Medical_recordService;
import cn.his.core.service.patient.PatientService;

@Controller
public class PatientController {
	
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private DrugService drugService;
	@Autowired
	private Medical_recordService medical_recordService;
	@Autowired
	private WardService wardService;
	@Autowired
	private Drug_recordService drug_recordService;
	@Autowired
	private SessionProvider sessionProvider;
	
	/**
	 * 挂号系统
	 * @param model
	 * @param msg
	 * @param department_code
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/toRegist.action")
	public String toRegist(ModelMap model, String msg, Patient patient, String department_code, String code) {
		if (code != null) {
			patient = patientService.findPatientByCode(code);
		}
		List<Department> departments = departmentService.findDepartmentList(new Department());
		model.addAttribute("departments", departments);
		model.addAttribute("msg", msg);
		model.addAttribute("department_code", department_code);
		model.addAttribute("patient", patient);
		return "registered";
	}

	/**
	 * 去挂号
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toRegister.action")
	public String toRegister(ModelMap model,  HttpServletRequest request, HttpServletResponse response) {
		Doctor doctor = (Doctor) sessionProvider.getAttribute(request, response, "doctorsession");
		if ("REGISTER".equals(doctor.getDuty())) {
			return "toregister";
		} else {
			model.addAttribute("msg", "权限不足，请确定权限后重试！");
			return "index_s";
		}
		
	}
	
	/**
	 * 挂号
	 * @param patient
	 * @param department_code
	 * @return
	 */
	@RequestMapping(value = "/regist.action", method = RequestMethod.POST)
	public String register(Patient patient, String department_code, ModelMap model) {
		if (patient.getName() == "" || patient.getSex() == "" || patient.getAge() == 0 || patient.getInsurance_type() == "" ||
				patient.getAddress() == "" || patient.getPhone() == "" || department_code == ""){
			model.addAttribute("msg", "请填写完整表单！");
			model.addAttribute("patient", patient);
			model.addAttribute("department_code", department_code);
			return "redirect:/toRegist.action";
		} else {
			if (patient.getCode() == null) {
				patientService.insertPatient(patient);
			} else {
				patientService.updatePatient(patient);
				Medical_record medical_record = new Medical_record();
				medical_record.setPatient_code(patient.getCode());
				medical_record.setDepartment_code(department_code);
				medical_recordService.insertMedical_record(medical_record);
			}
			model.addAttribute("msg", "挂号成功");
			model.addAttribute("code", "success");
			model.addAttribute("url", "/HIS/toRegister.action");
			model.addAttribute("urlname", "挂号系统");
			model.addAttribute("time", 3);
			return "message";
		}
	}
	
	/**
	 * 到病人信息去看病页面
	 * @param code
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/visit.action")
	public String visit(String code, String msg, ModelMap model) {
		Patient patient = patientService.findPatientByCode(code);
		if (patient != null) {
			Medical_record medical_record = new Medical_record();
			medical_record.setPatient_code(code);
			List<Medical_record> medical_records = medical_recordService.findMedical_records(medical_record);
			if (medical_records.size() > 0) {
				medical_record = medical_records.get(medical_records.size() - 1);
				model.addAttribute("medical_record", medical_record);
			} else {
				model.addAttribute("code", code);
			}
			List<Drug> drugs = drugService.findDrugs();
			List<Ward> wards = wardService.selectWardList();
			model.addAttribute("drugs", drugs);
			model.addAttribute("wards", wards);
			model.addAttribute("msg", msg);
			return "visit";
		} else {
			model.addAttribute("msg", "查无此人，请校对病人卡号！");
			return "tovisit";
		}
			
		
	}
	
	/**
	 * 去看病页面
	 * @return
	 */
	@RequestMapping(value = "/toVisit.action")
	public String toVisit(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Doctor doctor = (Doctor) sessionProvider.getAttribute(request, response, "doctorsession");
		if ("DOCTOR".equals(doctor.getDuty())) {
			return "tovisit";
		} else {
			model.addAttribute("msg", "权限不足，请确定权限后重试！");
			return "index_s";
		}
	}

	/**
	 * 诊疗
	 * @param druglist
	 * @param nums
	 * @return
	 */
	@RequestMapping(value = "/treatment.action", method = RequestMethod.POST)
	public String treatment(Medical_record medical_record, String[] druglist, Integer[] num, ModelMap model) {
		if (medical_record.isAssay() == true) {
			if (medical_record.getAssay_result() == "" || medical_record.getAssay_result() == null) {
				model.addAttribute("msg", "请填写化验结果！");
				model.addAttribute("code", medical_record.getPatient_code());
				return "redirect:/visit.action";
			}
		}
		if (medical_record.isExamination() == true) {
			if (medical_record.getExamination_result() == "" || medical_record.getExamination_result() == null) {
				model.addAttribute("msg", "请填写检查结果！");
				model.addAttribute("code", medical_record.getPatient_code());
				return "redirect:/visit.action";
			}
		}
		if (medical_record.getDiagnostic_result() == "" || medical_record.getDiagnostic_result() == null || medical_record.getTreatment() == "" || medical_record.getTreatment() == null) {
			model.addAttribute("msg", "请填写诊断结果和处理方法！");
			model.addAttribute("code", medical_record.getPatient_code());
			return "redirect:/visit.action";
		}
		if (medical_record.isHospitalization() == true) {
			if (medical_record.getWard_number() == "" || medical_record.getWard_number() == null || medical_record.getBed_number() == "" || medical_record.getBed_number() == null || medical_record.getHospitalization_days() == 0) {
				model.addAttribute("msg", "请选择病房，填写住院时间！");
				model.addAttribute("code", medical_record.getPatient_code());
				return "redirect:/visit.action";
			}
		}
		for (int i = 0; i < druglist.length; i++) {
			if (num[i] == null || druglist[i] == "" || druglist[i] == null) {
				model.addAttribute("msg", "请填写药品数量或名称！");
				model.addAttribute("code", medical_record.getPatient_code());
				return "redirect:/visit.action";
			}
			Drug_record drug_record = new Drug_record();
			drug_record.setDrug_code(druglist[i]);
			drug_record.setMedical_code(medical_record.getCode());
			drug_record.setNumber(num[i]);
			drug_record.setStatus(2);
			drug_recordService.insertDrug_record(drug_record);
		}
		if (medical_record.getWard_number() != null && medical_record.getBed_number() != null) {
			Ward ward = new Ward();
			ward.setWard_code(medical_record.getWard_number());
			ward.setBed_code(medical_record.getBed_number());
			ward = wardService.findWardByBed_codeAndWard_code(ward);
			ward.setOccupy(true);
			wardService.updateWardById(ward);
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-hh");
		medical_record.setDate(dateFormat.format(new Date()));
		if (medical_record.getCode() != null) {
			medical_recordService.updateMedical_record(medical_record);
		} else {
			medical_recordService.insertMedical_record(medical_record);
		}
		Patient patient = patientService.findPatientByCode(medical_record.getPatient_code());
		patient.setDoctor_code(medical_record.getDoctor_code());
		patientService.updatePatient(patient);
		model.addAttribute("msg", "就诊成功，请提醒病人前往缴费取药");
		model.addAttribute("code", "success");
		model.addAttribute("url", "/HIS/toVisit.action");
		model.addAttribute("urlname", "诊疗系统");
		model.addAttribute("time", 5);
		return "message";
	}
	
	/**
	 * 病床
	 * @param ward_code
	 * @param response
	 */
	@RequestMapping(value = "/beds.action")
	public void beds(String ward_code, HttpServletResponse response) {
		List<Ward> beds = wardService.findLessBedByWard_code(ward_code);
		JSONObject jo = new JSONObject();
		jo.put("beds", beds);
		ResponseUtils.renderJson(response, jo.toString());
	}
}
