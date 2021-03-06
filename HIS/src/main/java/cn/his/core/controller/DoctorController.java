package cn.his.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;

import cn.his.common.utils.Md5Utils;
import cn.his.common.web.ResponseUtils;
import cn.his.common.web.SessionProvider;
import cn.his.core.model.doctor.Department;
import cn.his.core.model.doctor.Doctor;
import cn.his.core.model.patient.Patient;
import cn.his.core.service.doctor.DepartmentService;
import cn.his.core.service.doctor.DoctorService;
import cn.his.core.service.patient.PatientService;

/**
 * 前台医生模块
 * @author chenruiying
 *
 */
@Controller
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private SessionProvider sessionProvider;
	@Autowired
	private PatientService patientService;
	
	/**
	 * 去前台登陆页面
	 * @return
	 */
	@RequestMapping(value = "/toLogin.action")
	public String toLogin() {
		return "login_s";
	}
	
	/**
	 * 登陆
	 * @param code
	 * @param password
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/login.action")
	public String login(String code, String password, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		Doctor doctor = doctorService.login(code, password);
		if (doctor != null) {
			sessionProvider.setAttribute(request, response, "doctorsession", doctor);
			if (doctor.isFirst()) {
				return "redirect:/toUpdate.action";
			}
			return "redirect:/toIndex.action";
		} else {
			model.addAttribute("title", "登陆失败");
			model.addAttribute("msg", "用户名或密码错误");
			model.addAttribute("status", "error");
			model.addAttribute("code", code);
			model.addAttribute("password", password);
			return "login_s";
		}
		
	}
	
	/**
	 * 退出登陆
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/logout.action")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		sessionProvider.logout(request, response);
		return "login_s";
	}
	
	/**
	 * 医生信息
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/toInfo.action")
	public String toInfo(String code, ModelMap model) {
		Doctor doctor = doctorService.findDoctorByCode(code);
		String departmentName = departmentService.findDepartmentByCode(doctor.getDepartment_code()).getName();
		List<Department> list = departmentService.findDepartmentList(new Department());
		Patient patient = new Patient();
		patient.setDoctor_code(code);
		List<Patient> patients = patientService.findPatients(patient);
		model.addAttribute("doctor", doctor);
		model.addAttribute("departmentName", departmentName);
		model.addAttribute("departmentlist", list);
		model.addAttribute("patients", patients);
		return "doctor";
	}
	
	/**
	 * 去更新密码页面
	 * @return
	 */
	@RequestMapping(value = "/toUpdate.action")
	public String toUpdatePassword() {
		return "updatepassword";
	}
	
	/**
	 * 更新密码
	 * @param code
	 * @param pw
	 * @param pw1
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/updatepasswd.action", method= RequestMethod.POST)
	public void updatePassWord(String pw, String pw1, ModelMap model, HttpServletRequest request, HttpServletResponse response){
		Doctor doctor = (Doctor) sessionProvider.getAttribute(request, response, "doctorsession");
		JSONObject jsonObject = new JSONObject();
		if (!Md5Utils.md5(pw).equals(doctor.getPassword())) {
			jsonObject.put("yes", false);
			jsonObject.put("title", "操作失败");
			jsonObject.put("msg", "原密码错误!");
			jsonObject.put("status", "error");
		} else {
			doctor.setPassword(Md5Utils.md5(pw1));
			doctor.setFirst(false);
			doctorService.updateDoctor(doctor);
			sessionProvider.logout(request, response);
			jsonObject.put("title", "操作成功");
			jsonObject.put("msg", "修改密码成功!");
			jsonObject.put("status", "success");
			jsonObject.put("yes", true);
		}
		ResponseUtils.renderJson(response, jsonObject.toString());
	}
	
	/**
	 * 医生修改个人信息
	 * @param doctor
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editDoctor.action")
	public String editDoctor(Doctor doctor, ModelMap model) {
		if (doctorService.updateDoctor(doctor)) {
			model.addAttribute("code", doctor.getCode());
			return "redirect:/toInfo.action";
		} else {
			String departmentName = departmentService.findDepartmentByCode(doctor.getDepartment_code()).getName();
			model.addAttribute("doctor", doctor);
			model.addAttribute("departmentName", departmentName);
			model.addAttribute("msg", "修改失败，请重试！");
			return "doctor";
		}
	}
	
	/**
	 * 去首页
	 * @return
	 */
	@RequestMapping(value = "/toIndex.action")
	public String toIndex() {
		return "index_s";
	}
	
	/**
	 * 头部
	 * @return
	 */
	@RequestMapping(value = "/toHead.action")
	public String toHead(String name, ModelMap model) {
		if ("fee".equals(name)) {
			model.addAttribute("name", "收费系统");
		} else if ("frontindex".equals(name)) {
			model.addAttribute("name", "首页");
		} else if ("password".equals(name)) {
			model.addAttribute("name", "修改密码");
		} else if ("register".equals(name)) {
			model.addAttribute("name", "挂号系统");
		} else if ("message".equals(name)) {
			model.addAttribute("name", "信息系统");
		} else if ("drug".equals(name)) {
			model.addAttribute("name", "取药系统");
		} else if ("visit".equals(name)) {
			model.addAttribute("name", "就诊系统");
		} else if ("doctor".equals(name)) {
			model.addAttribute("name", "个人信息");
		}
		return "head";
	}

}
