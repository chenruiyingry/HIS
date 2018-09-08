package cn.his.core.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.his.common.web.SessionProvider;
import cn.his.core.model.admin.Admin;
import cn.his.core.service.admin.AdminService;

/**
 * 后台登陆和主要模块
 * @author chenruiying
 *
 */
@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private SessionProvider sessionProvider;
	
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @param username
	 * @param password
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/login.do", method=RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, String username, String password, ModelMap model) {
		Admin admin = adminService.getUserByUsername(username, password);
		if (admin != null) {
			sessionProvider.setAttribute(request, response, "admin_session", admin);
			return "redirect:/admin/toIndex.do";
		} else {
			model.addAttribute("username", username);
			model.addAttribute("password", password);
			model.addAttribute("msg", "用户名或密码错误");
			return "login";
		}
	}
	
	/**
	 * 退出登录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/admin/logout.do")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		sessionProvider.logout(request, response);
		return "redirect:/admin/toLogin.do";
	}
	
	/**
	 * 去登录页面
	 * @return
	 */
	@RequestMapping(value = "/admin/toLogin.do")
	public String toLogin() {
		return "login";
	}
	
	/**
	 * 去首页
	 * @return
	 */
	@RequestMapping(value = "/admin/toIndex.do")
	public String toIndex() {
		return "index";
	}
	
	/**
	 * 页面头部
	 * @param headname
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/toHead.do")
	public String toHead(String headname, ModelMap model) {
		if ("index".equals(headname)) {
			model.addAttribute("name", "后台管理");
		} else if ("doctor".equals(headname)) {
			model.addAttribute("name", "医生管理");
		} else if ("drug".equals(headname)) {
			model.addAttribute("name", "药品管理");
		} else if ("patient".equals(headname)) {
			model.addAttribute("name", "病人管理");
		} else if ("cost".equals(headname)) {
			model.addAttribute("name", "收费管理");
		} else if ("department".equals(headname)) {
			model.addAttribute("name", "科室管理");
		} else if ("division".equals(headname)) {
			model.addAttribute("name", "部门管理");
		} else if ("ward".equals(headname)) {
			model.addAttribute("name", "病房管理");
		}
		return "head";
	}
}
