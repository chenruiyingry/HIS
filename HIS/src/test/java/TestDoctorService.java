import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.his.common.page.Pagination;
import cn.his.common.utils.Md5Utils;
import cn.his.core.model.Sex;
import cn.his.core.model.doctor.Doctor;
import cn.his.core.service.doctor.DoctorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestDoctorService {

	@Autowired
	private DoctorService doctorService;
	
	@Test
	public void testAddDoctor() throws Exception {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = format.format(date);
		Doctor doctor = new Doctor();
		doctor.setCode("222225");
		doctor.setPassword(Md5Utils.md5("root"));
		doctor.setName("王晓伟");
		doctor.setSex(Sex.MAN);
		doctor.setNative_place("广东佛山");
		doctor.setNation("汉");
		doctor.setBirth(dateStr);
		doctor.setDegree("本科");
		doctor.setGraduate("北京大学");
		doctor.setAddress("广东天河城");
		doctor.setPhone("12345678912");
		doctor.setEmail("123456@163.com");
		doctor.setQualification("abc123456");
		doctor.setLicense("des123456");
		doctor.setDepartment("1234");
		doctor.setFirst(true);
		doctor.setTitle("扫地");
		doctor.setDuty("医生");
		doctor.setHiredate(dateStr);
		doctor.setMajor("医学");
		doctor.setRemark("明天上班");
		doctor.setWork(true);
		doctor.setWork_time(dateStr);
		doctor.setImage_url("localhost/123.jpg");
		doctor.setIntroduction("牛逼的医生");
		System.out.println("医生信息：" + doctor.toString());
		doctorService.insertDoctor(doctor);
		System.out.println("添加成功");
	}
	
	@Test
	public void TestGetDoctorByCode() throws Exception {
		Doctor doctor = doctorService.findDoctorByCode("326525");
		System.out.println(doctor);
	}
	
	@Test
	public void TestUpdateDoctor() throws Exception {
		Doctor doctor = new Doctor();
		System.out.println("修改前医生信息：" + doctor.toString());
//		dinformation.setDcode("352623");
//		dinformation.setDacademicdegree("789645634651");
//		dinformation.setDaddress("西安政法大学");
//		dinformation.setDgraduate("清华大学");
//		dinformation.setDimage("116545341/15613");
//		dinformation.setDname("张三");
//		dinformation.setDnation("广东佛山");
//		dinformation.setDnativeplace("广东");
//		dinformation.setDphone("1234567891231");
//		dinformation.setDsex(1);
//		System.out.println("修改后医生信息：" + dinformation.toString());
//		doctorService.updateDoctor(dinformation);
//		System.out.println("修改后表中医生信息：" + doctorService.getDoctorByCode("352623"));
		System.out.println("修改成功");
	}
	
	@Test
	public void TestDeleteDoctor() throws Exception {
		if (doctorService.deleteDoctorByCode("222223")) {
			System.out.println("删除成功");
		}
	}
	
	@Test
	public void TestGetDoctorList() throws Exception {
		Doctor doctor = new Doctor();
		doctor.setPageNo(Pagination.cpn(2));
		doctor.setPageSize(5);
		Pagination pagination = doctorService.findDoctorListWithPage(doctor);
		
		System.out.println("查询得到的对象为：" + pagination.getList());
	}
	
	@Test
	public void TestLogin() throws Exception {
		String code = "222225";
		String password = "root1";
		Doctor doctor = new Doctor();
		doctor.setCode(code);
		doctor = doctorService.findDoctorByCode(code);
		if (Md5Utils.md5(password).equals(doctor.getPassword())) {
			System.out.println("登录成功");
		} else {
			System.out.println("登录失败");
		}
	}
	
	@Test
	public void TestChangePassword() throws Exception {
		String code = "222225";
		String password1 = "root";
		String password2 = "abcd";
		Doctor doctor = doctorService.findDoctorByCode(code);
		System.out.println(doctor.toString());
		if (Md5Utils.md5(password1).equals(doctor.getPassword())) {
			doctor.setPassword(Md5Utils.md5(password2));
			System.out.println(doctor.toString());
			doctorService.updateDoctor(doctor);
			System.out.println("修改成功");
		} else {
			System.out.println("登录失败");
		}
	}
}
