package cn.his.core.controller.admin;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import cn.his.common.web.ResponseUtils;
import cn.his.common.page.Pagination;
import cn.his.common.utils.Md5Utils;
import cn.his.core.model.doctor.Department;
import cn.his.core.model.doctor.Doctor;
import cn.his.core.service.doctor.DepartmentService;
import cn.his.core.service.doctor.DoctorService;

@Controller
public class AdminDoctorController {

	@Autowired
	private DoctorService doctorService;
	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * 医生列表
	 * @param model
	 * @param pageNo
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/admin/doctorList.do")
	public String doctorList(ModelMap model, Integer pageNo, String name) {
		Doctor doctor = new Doctor();
		StringBuilder params = new StringBuilder();
		if (StringUtils.isNotBlank(name)) {
			doctor.setName(name);
			params.append("name=").append(name);
		}
		doctor.setPageNo(Pagination.cpn(pageNo));
		doctor.setPageSize(7);
		Pagination pagination = doctorService.findDoctorListWithPage(doctor);	
		String url = "/HIS/admin/doctorList.do";
		pagination.pageView(url, params.toString());
		model.addAttribute("pagination", pagination);
		return "doctor_s";
	}
	
	@RequestMapping(value = "/admin/deleteDoctor.do")
	public String deleteDoctor(int id) {
		doctorService.deleteDoctorByCode(id);
		return "redirect:/admin/doctorList.do";
	}
	
	/**
	 * 上传图片
	 * @param pic
	 * @param response
	 */
	@RequestMapping(value = "/doctor/uploadPic.do")
	public void upload(@RequestParam(required = false) MultipartFile pic, HttpServletResponse response) {
		//扩展名
		String ext = FilenameUtils.getExtension(pic.getOriginalFilename());
		//图片名称生成策略
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		//名称一部分
		String format = df.format(new Date());
		//随机三位数
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			format += r.nextInt(10);
		}
		
		//实例化一个Jersey
		Client client = new Client();
		
		String path = "his/" + format + "." + ext;
		
		String url = "http://localhost:8080/img/" + path;
		//设置请求路径
		WebResource resource = client.resource(url);
		
		//发送开始
		try {
			resource.put(String.class, pic.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//返回二个路径
		JSONObject jo = new JSONObject();
		jo.put("url", url);
		jo.put("path", path);
		ResponseUtils.renderJson(response, jo.toString());
	}
	
	@RequestMapping(value = "/admin/doctor.do")
	public String toDoctorInfo(String code, ModelMap model) throws ParseException {
		Doctor doctor = doctorService.findDoctorByCode(code);
		doctor.setDepartment_code(departmentService.findDepartmentByCode(doctor.getDepartment_code()).getName());
		if ("CHIEF".equals(doctor.getLevel())) {
			doctor.setLevel("主任医师");
		} else if ("ASSOCIATECHIEF".equals(doctor.getLevel())) {
			doctor.setLevel("副主任医师");
		} else if ("ATTENDING".equals(doctor.getLevel())) {
			doctor.setLevel("主治医师");
		} else if ("RESIDENT".equals(doctor.getLevel())) {
			doctor.setLevel("住院医师");
		} else if ("PHYSICIAN".equals(doctor.getLevel())) {
			doctor.setLevel("医师");
		} else if ("FELDSHER".equals(doctor.getLevel())) {
			doctor.setLevel("医士");
		} 
		if ("MAN".equals(doctor.getSex())) {
			doctor.setSex("男");
		} else if ("WOMAN".equals(doctor.getSex())) {
			doctor.setSex("女");
		}
		List<Department> list = departmentService.findDepartmentList(new Department());
		doctor.setWork_time(doctor.getWork_time().replace(" ", "T"));
		doctor.setOutwork_time(doctor.getOutwork_time().replace(" ", "T"));
		model.addAttribute("doctor", doctor);
		model.addAttribute("departmentlist", list);
		return "doctor_i";
	}
	
	@RequestMapping(value = "/admin/toAdd.do")
	public String toAddDoctor(ModelMap model) {
		model.addAttribute("code", "yesyes");
		List<Department> list = departmentService.findDepartmentList(new Department());
		model.addAttribute("departmentlist", list);
		return "doctor_i";
	}
	
	@RequestMapping(value = "/admin/editDoctor.do")
	public String editDoctor(Doctor doctor) {
		doctorService.updateDoctor(doctor);
		return "redirect:/admin/doctorList.do";
	}
	
	@RequestMapping(value = "admin/addDoctor.do")
	public String addDoctor(Doctor doctor) {
		doctor.setWork_time(doctor.getWork_time().replace("T", " "));
		doctor.setOutwork_time(doctor.getOutwork_time().replace("T", " "));
		doctor.setFirst(true);
		doctor.setPassword(Md5Utils.md5("123456"));
		doctorService.insertDoctor(doctor);
		return "redirect:/admin/doctorList.do";
	}
}
