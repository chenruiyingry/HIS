package cn.his.core.controller.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.his.core.service.doctor.DoctorService;

@Controller
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	/**
	 * 去前台登陆页面
	 * @return
	 */
	@RequestMapping(value = "/toLogin.action")
	public String toLogin() {
		return "login_s";
	}
}
