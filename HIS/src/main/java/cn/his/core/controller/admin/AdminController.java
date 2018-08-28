package cn.his.core.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.his.common.web.SessionProvider;
import cn.his.core.model.admin.Admin;
import cn.his.core.service.admin.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminLoginService;
	
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
	@RequestMapping(value = "/admin/login.do")
	public String login(HttpServletRequest request, HttpServletResponse response, String username, String password, ModelMap model) {
		Admin admin = adminLoginService.getUserByUsername(username, password);
		if (admin != null) {
			sessionProvider.setAttribute(request, response, "admin", admin.getUsername());
			model.addAttribute("登录成功！");
			return "r:/index.jsp";
		} 
		model.addAttribute("登录失败！");
		return "login.jsp";
	}
	
	/**
	 * 去登录页面
	 * @return
	 */
	@RequestMapping(value = "/admin/toLogin.do")
	public String toLogin() {
		return "admin/login.jsp";
	}
}
