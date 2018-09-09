package cn.his.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.his.core.model.drug.Drug;
import cn.his.core.model.drug.Drug_record;
import cn.his.core.model.patient.Medical_record;
import cn.his.core.model.patient.Patient;
import cn.his.core.service.drug.Drug_recordService;
import cn.his.core.service.patient.Medical_recordService;
import cn.his.core.service.patient.PatientService;

@Controller
public class DrugController {

	@Autowired
	private PatientService patientService;
	@Autowired
	private Medical_recordService medical_recordService;
	@Autowired
	private Drug_recordService drug_recordService;
	
	/**
	 * 去取药页面
	 * @return
	 */
	@RequestMapping(value = "toDrug.action")
	public String toDrug() {
		return "todrug";
	}
	
	/**
	 * 查询药品
	 * @param code
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "drug.action")
	public String drug(String code, ModelMap model) {
		Patient patient = patientService.findPatientByCode(code);
		if (patient != null) {
			Medical_record medical_record = new Medical_record();
			medical_record.setPatient_code(code);
			List<Medical_record> medical_records = medical_recordService.findMedical_records(medical_record);
			medical_record = medical_records.get(medical_records.size() - 1);
			if (medical_record.getDrug_record().get(medical_record.getDrug_record().size() - 1).getStatus() == 0) {
				model.addAttribute("status", "未取药");
			} else {
				model.addAttribute("status", "已取药");
			}
			model.addAttribute("patient", patient);
			model.addAttribute("druglist", medical_record.getDrug_record());
			model.addAttribute("medical_record", medical_record);
			return "takemedicine";
		} else {
			model.addAttribute("msg", "查无此人，稍后再试");
			return "todrug";
		}
	}
	
	/**
	 * 取药
	 * @param medical_record
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "takeDrug.action")
	public String takeDrug(String medical_record, ModelMap model) {
		Medical_record medical_record2 = medical_recordService.findMedical_recordByCode(medical_record);
		List<Drug_record> drug_records = medical_record2.getDrug_record();
		for (Drug_record drug_record : drug_records) {
			drug_record.setStatus(1);
			drug_recordService.updateDrug_record(drug_record);
		}
		model.addAttribute("msg", "取药成功");
    	model.addAttribute("code", "success");
    	model.addAttribute("urlname", "取药页面");
    	model.addAttribute("url", "toDrug.action");
    	model.addAttribute("time", 5);
		return "message";
	}
}
