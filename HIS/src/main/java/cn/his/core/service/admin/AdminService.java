package cn.his.core.service.admin;

import cn.his.core.model.admin.Admin;

public interface AdminService {

	/**
	 * 管理员登录
	 * @param username
	 * @param password
	 * @return
	 */
	public Admin getUserByUsername(String username, String password);
}
