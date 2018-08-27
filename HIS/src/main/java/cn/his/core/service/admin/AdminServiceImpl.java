package cn.his.core.service.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.his.common.utils.Md5Utils;
import cn.his.core.dao.admin.AdminDao;
import cn.his.core.model.admin.Admin;;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Resource
	private AdminDao adminDao;

	/**
	 * 管理员登录
	 */
	@Override
	public Admin getUserByUsername(String username, String password) {
		//System.out.println("输入的用户名为：" + username + "，密码为：" + password);
		Admin admin = adminDao.getUserByUsername(username);
		if (admin != null) {
			//System.out.println("查询出来的用户名为：" + admin.getUsername() + "，密码为：" + admin.getPassword());
			//System.out.println("输入密码解密为：" + Md5Utils.md5(password));
			if (admin.getUsername().equals(username) && admin.getPassword().equals(Md5Utils.md5(password))) {
				return admin;
			} 
		}
		return null;
	}

}
