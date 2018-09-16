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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import cn.his.common.web.ResponseUtils;
import cn.his.common.page.Pagination;
import cn.his.common.utils.Md5Utils;
import cn.his.core.model.doctor.Department;
import cn.his.core.model.doctor.Doctor;
import cn.his.core.model.patient.Patient;
import cn.his.core.service.doctor.DepartmentService;
import cn.his.core.service.doctor.DoctorService;
import cn.his.core.service.patient.PatientService;

/**
 * 后台医生模块
 * @author chenruiying
 *
 */
@Controller
public class AdminDoctorController {

	@Autowired
	private DoctorService doctorService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private PatientService patientService;
	
	/**
	 * 医生列表
	 * @param model
	 * @param pageNo
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/admin/doctorList.do")
	public String doctorList(ModelMap model, Integer pageNo, String name, String msg, String status, String title) {
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
		model.addAttribute("msg", msg);
		model.addAttribute("status", status);
		model.addAttribute("title", title);
		return "doctor_s";
	}
	
	/**
	 * 医生信息
	 * @param code
	 * @param model
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/admin/doctor.do")
	public String toDoctorInfo(String code, ModelMap model, String msg, String status, String title) throws ParseException {
		Doctor doctor = doctorService.findDoctorByCode(code);
		String departmentName = departmentService.findDepartmentByCode(doctor.getDepartment_code()).getName();
		List<Department> list = departmentService.findDepartmentList(new Department());
		Patient patient = new Patient();
		patient.setDoctor_code(code);
		List<Patient> patients = patientService.findPatients(patient);
		doctor.setWork_time(doctor.getWork_time().replace(" ", "T"));
		doctor.setOutwork_time(doctor.getOutwork_time().replace(" ", "T"));
		model.addAttribute("doctor", doctor);
		model.addAttribute("departmentlist", list);
		model.addAttribute("departmentName", departmentName);
		model.addAttribute("msg", msg);
		model.addAttribute("status", status);
		model.addAttribute("title", title);
		model.addAttribute("patients", patients);
		return "doctor_i";
	}
	
	/**
	 * 去添加医生
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/toAdd.do")
	public String toAddDoctor(ModelMap model, String msg, Doctor doctor, String status, String title) {
		model.addAttribute("code", "yesyes");
		List<Department> list = departmentService.findDepartmentList(new Department());
		model.addAttribute("departmentlist", list);
		model.addAttribute("msg", msg);
		model.addAttribute("status", status);
		model.addAttribute("title", title);
		doctor.setImage_url("his/add.png");
		model.addAttribute("doctor", doctor);
		return "doctor_i";
	}
	
	/**
	 * 添加医生
	 * @param doctor
	 * @return
	 */
	@RequestMapping(value = "admin/addDoctor.do", method = RequestMethod.POST)
	public String addDoctor(Doctor doctor, ModelMap model) {
		if (doctor.getName() == "" || doctor.getAddress() == "" || doctor.getBirth() == "" || doctor.getDegree() == "" ||
				doctor.getDepartment_code() == "" || doctor.getDuty() == "" || doctor.getEmail() == "" ||
				doctor.getGraduate() == "" || doctor.getHiredate() == "" || doctor.getImage_url() == "" || doctor.getIntroduction() == ""|| 
				doctor.getLevel() == "" || doctor.getLicense() == "" || doctor.getMajor() == "" || doctor.getNation() == "" ||
				doctor.getNative_place() == "" || doctor.getOutwork_time() == "" || doctor.getPhone() == "" || doctor.getQualification() == "" ||
				doctor.getSex() == "" || doctor.getTitle() == "" || doctor.getWork_time() == "") {
			model.addAttribute("title", "操作失败");
			model.addAttribute("msg", "请填写完整表单！");
			model.addAttribute("status", "error");
			model.addAttribute("doctor", doctor);
			return "redirect:/admin/toAdd.do";
		} else {
			if (doctorService.findDoctorByCode(doctor.getCode()) != null) {
				model.addAttribute("title", "操作失败");
				model.addAttribute("msg", "医生编号已被使用！");
				model.addAttribute("status", "error");
				model.addAttribute("doctor", doctor);
				return "redirect:/admin/toAdd.do";
			} else {
				doctor.setFirst(true);
				doctor.setWorknow(false);
				doctor.setPassword(Md5Utils.md5("123456"));
				doctorService.insertDoctor(doctor);
				model.addAttribute("title", "操作成功");
				model.addAttribute("msg", "添加医生成功！");
				model.addAttribute("status", "success");
				return "redirect:/admin/doctorList.do";
			}
		}
	}
	
	/**
	 * 修改医生信息
	 * @param doctor
	 * @return
	 */
	@RequestMapping(value = "/admin/editDoctor.do", method = RequestMethod.POST)
	public String editDoctor(Doctor doctor, ModelMap model) {
		if (doctor.getName() == "" || doctor.getAddress() == "" || doctor.getBirth() == "" || doctor.getDegree() == "" ||
				doctor.getDepartment_code() == "" || doctor.getDuty() == "" || doctor.getEmail() == "" ||
				doctor.getGraduate() == "" || doctor.getHiredate() == "" || doctor.getImage_url() == "" || doctor.getIntroduction() == ""|| 
				doctor.getLevel() == "" || doctor.getLicense() == "" || doctor.getMajor() == "" || doctor.getNation() == "" ||
				doctor.getNative_place() == "" || doctor.getOutwork_time() == "" || doctor.getPhone() == "" || doctor.getQualification() == "" ||
				doctor.getSex() == "" || doctor.getTitle() == "" || doctor.getWork_time() == "") {
			model.addAttribute("title", "操作失败");
			model.addAttribute("msg", "请填写完整表单！");
			model.addAttribute("status", "error");
			model.addAttribute("code", doctor.getCode());
			return "redirect:/admin/doctor.do?";
		} else {
			doctorService.updateDoctor(doctor);
			model.addAttribute("title", "操作成功");
			model.addAttribute("msg", "医生信息修改成功！");
			model.addAttribute("status", "success");
			model.addAttribute("code", doctor.getCode());
			return "redirect:/admin/doctor.do";
		}
	}
	
	/**
	 * 删除医生
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/deleteDoctor.do")
	public String deleteDoctor(ModelMap model, int id) {
		doctorService.deleteDoctorByCode(id);
		model.addAttribute("title", "操作成功");
		model.addAttribute("msg", "删除医生成功！");
		model.addAttribute("status", "success");
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
			e.printStackTrace();
		}
		//返回二个路径
		JSONObject jo = new JSONObject();
		jo.put("url", url);
		jo.put("path", path);
		ResponseUtils.renderJson(response, jo.toString());
	}
}
