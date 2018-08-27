import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.his.core.model.admin.Admin;
import cn.his.core.service.admin.AdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestAdminService{

	@Autowired
	private AdminService adminLoginService;
	
	@Test
	public void testLogin() throws Exception { 
		System.out.println("开始测试。。。。。");
		Admin admin = adminLoginService.getUserByUsername("root", "root");
		System.out.println(admin);
		System.out.println("测试结束。。。。。");
	}
}
