package cn.his.core.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.his.common.web.SessionProvider;
import cn.his.core.model.doctor.Doctor;

public class SessionInterceptor implements HandlerInterceptor {
	
	@Autowired
	private SessionProvider sessionProvider;
	
	private List<String> excludeUrls;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String path = request.getServletPath();
		
		if (excludeUrls.contains(path)) {
			return true;
		} else {
			Doctor doctor = (Doctor) sessionProvider.getAttribute(request, response, "doctorsession");
			//必须登录
			if (null == doctor) {
				response.sendRedirect("/HIS/toLogin.action");
			} else {
				return true;
			}
		}
		return false;
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	
}
