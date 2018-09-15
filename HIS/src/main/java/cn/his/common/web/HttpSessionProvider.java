package cn.his.common.web;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpSessionProvider implements SessionProvider {

	@Override
	public void setAttribute(HttpServletRequest request, HttpServletResponse response, String name, Serializable value) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute(name, value);
	}

	@Override
	public Serializable getAttribute(HttpServletRequest request, HttpServletResponse response, String name) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session != null) {
			return (Serializable) session.getAttribute(name);
		}
		return null;
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}

	@Override
	public String getSessionId(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return request.getSession().getId();
	}

	@Override
	public long getSessionTime(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return request.getSession().getCreationTime();
	}

}
