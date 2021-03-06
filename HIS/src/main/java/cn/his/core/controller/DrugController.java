package cn.his.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import cn.his.common.web.ResponseUtils;
import cn.his.common.web.SessionProvider;
import cn.his.core.model.doctor.Doctor;
import cn.his.core.model.drug.Drug;
import cn.his.core.model.drug.Drug_record;
import cn.his.core.model.patient.Medical_record;
import cn.his.core.model.patient.Patient;
import cn.his.core.service.drug.DrugService;
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
	@Autowired
	private DrugService drugService;
	@Autowired
	private SessionProvider sessionProvider;
	
	/**
	 * 去取药页面
	 * @return
	 */
	@RequestMapping(value = "toDrug.action")
	public String toDrug(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Doctor doctor = (Doctor) sessionProvider.getAttribute(request, response, "doctorsession");
		if ("PHARMACIST".equals(doctor.getDuty())) {
			return "todrug";
		} else {
			model.addAttribute("title", "操作失败");
			model.addAttribute("msg", "权限不足，请重试！");
			model.addAttribute("status", "error");
			return "index_s";
		}
	}
	
	/**
	 * 查询药品
	 * @param code
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "drug.action")
	public String drug(String code, ModelMap model) {
		try {
			Patient patient = patientService.findPatientByCode(code);
			if (patient != null) {
				Medical_record medical_record = new Medical_record();
				medical_record.setPatient_code(code);
				List<Medical_record> medical_records = medical_recordService.findMedical_records(medical_record);
				medical_record = medical_records.get(medical_records.size() - 1);
				if (medical_record.getDrug_record().get(medical_record.getDrug_record().size() - 1).getStatus() == 2) {
					model.addAttribute("title", "操作失败");
					model.addAttribute("msg", "病人未缴费，不能取药！");
					model.addAttribute("status", "error");
					model.addAttribute("code", code);
					return "todrug";
				} else if (medical_record.getDrug_record().get(medical_record.getDrug_record().size() - 1).getStatus() == 0) {
					model.addAttribute("status", "未取药");
				} else {
					model.addAttribute("status", "已取药");
				}
				model.addAttribute("patient", patient);
				model.addAttribute("druglist", medical_record.getDrug_record());
				model.addAttribute("medical_record", medical_record);
				return "takemedicine";
			} else {
				model.addAttribute("title", "操作失败");
				model.addAttribute("msg", "查无此人，请重新输入卡号！");
				model.addAttribute("status", "error");
				model.addAttribute("code", code);
				return "todrug";
			}
		} catch (Exception e) {
			model.addAttribute("title", "操作失败");
			model.addAttribute("msg", "操作异常，请稍后重试！");
			model.addAttribute("status", "error");
			model.addAttribute("code", code);
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
		try {
			Medical_record medical_record2 = medical_recordService.findMedical_recordByCode(medical_record);
			List<Drug_record> drug_records = medical_record2.getDrug_record();
			boolean flag = false;
			for (Drug_record drug_record : drug_records) {
				Drug drug = drugService.findDrugByCode(drug_record.getDrug_code());
				if (drug.getStore() >= drug_record.getNumber()) {
					drug.setStore(drug.getStore() - drug_record.getNumber());
					drugService.updateDrug(drug);
					drug_record.setStatus(1);
					drug_recordService.updateDrug_record(drug_record);
				} else {
					model.addAttribute("title", "操作失败");
					model.addAttribute("msg", "药品库存不足，取药失败！");
					model.addAttribute("status", "error");
					flag = true;
					break;
				}
			}
			if (!flag) {
				model.addAttribute("title", "操作成功");
				model.addAttribute("msg", "取药成功！");
				model.addAttribute("status", "success");
			}
			return "todrug";
		} catch (Exception e) {
			model.addAttribute("title", "操作失败");
			model.addAttribute("msg", "操作异常，请稍后重试！");
			model.addAttribute("status", "error");
			return "todrug";
		}
	}
	
	/**
	 * 药品信息
	 * @param code
	 * @param response
	 */
	@RequestMapping(value = "/drugInfo.action")
	public void drugInfo(String code, HttpServletResponse response) {
		Drug drug = drugService.findDrugByCode(code);
		JSONObject jsonObject = new JSONObject();
		@SuppressWarnings("static-access")
		String jsonString = jsonObject.toJSONString(drug);
		ResponseUtils.renderJson(response, jsonString);
	}
}
