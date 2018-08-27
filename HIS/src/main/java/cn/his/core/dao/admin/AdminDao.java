package cn.his.core.dao.admin;

import cn.his.core.model.admin.Admin;

public interface AdminDao {

	/**
	 * 通过用户名获得账户信息
	 * @param username
	 * @return
	 */
	public Admin getUserByUsername(String username);
}
