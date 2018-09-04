package cn.his.core.controller.doctor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.his.common.web.SessionProvider;
import cn.his.core.model.doctor.Doctor;
import cn.his.core.service.doctor.DoctorService;

@Controller
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	@Autowired
	private SessionProvider sessionProvider;
	
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
			return "index";
		} else {
			model.addAttribute("msg", "用户名或密码错误");
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
	 * 头部
	 * @return
	 */
	@RequestMapping(value = "/toHead.action")
	public String toHead(String name, ModelMap model) {
		if ("fee".equals(name)) {
			model.addAttribute("name", "收费系统");
		} else if ("frontindex".equals(name)) {
			model.addAttribute("name", "前台首页");
		} 
		return "head";
	}
}
