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
}
