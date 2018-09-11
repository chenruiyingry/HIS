package cn.his.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.his.common.utils.Md5Utils;
import cn.his.common.web.SessionProvider;
import cn.his.core.model.doctor.Doctor;
import cn.his.core.service.doctor.DoctorService;

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
			if (doctor.isFirst()) {
				return "redirect:/toUpdate.action";
			}
			sessionProvider.setAttribute(request, response, "doctorsession", doctor);
			return "redirect:/toIndex.action";
		} else {
			model.addAttribute("msg", "用户名或密码错误");
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
	@SuppressWarnings("unused")
	@RequestMapping(value="/updatepasswd.action")
	public String updatePassWord(String code, String pw, String pw1, ModelMap model, HttpServletRequest request, HttpServletResponse response){
		Doctor doctor = doctorService.login(code, pw);
		Doctor doctor1 = new Doctor();
		doctor1.setId(doctor.getId());
		doctor1.setCode(code);
		doctor1.setPassword(Md5Utils.md5(pw1));
		if (doctor == null) {
			model.addAttribute("msg", "原密码错误");
			return "updatepassword";
		} else {
			doctor1.setFirst(false);
			doctorService.updateDoctor(doctor1);
			sessionProvider.logout(request, response);
			model.addAttribute("msg", "修改密码成功");
			model.addAttribute("code", "success");
			model.addAttribute("url", "/HIS/toLogin.action");
			model.addAttribute("urlname", "登陆页面");
			model.addAttribute("time", 3);
			return "message";
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
		}
		return "head";
	}
	
	/**
	 * 信息板
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "msg.action")
	public String toMsg(ModelMap model) {
		model.addAttribute("msg", "支付宝支付成功");
    	model.addAttribute("code", "error");
    	model.addAttribute("urlname", "收费页面");
    	model.addAttribute("url", "toFee.action");
    	model.addAttribute("time", 5);
		return "message";
	}
}
