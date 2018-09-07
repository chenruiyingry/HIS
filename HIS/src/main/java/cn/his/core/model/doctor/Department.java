package cn.his.core.model.doctor;

import java.util.List;

import cn.his.core.model.Page;

/*
 * 科室表
 */
public class Department extends Page {

	private int id;//id
	private String code;//科室编号
	private String p_code;//部门编号
	private String name;//科室名字
	private String introduction;//简介
	private int doctornum;
	private int departmentnum;
	private List<Doctor> doctors;

	public Department(int id, String code, String p_code, String name, String introduction, List<Doctor> doctors) {
		super();
		this.id = id;
		this.code = code;
		this.p_code = p_code;
		this.name = name;
		this.introduction = introduction;
		this.doctors = doctors;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDoctornum() {
		return doctornum;
	}

	public int getDepartmentnum() {
		return departmentnum;
	}

	public void setDepartmentnum(int departmentnum) {
		this.departmentnum = departmentnum;
	}

	public void setDoctornum(int doctornum) {
		this.doctornum = doctornum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", code=" + code + ", p_code=" + p_code + ", name=" + name + ", introduction="
				+ introduction + ", doctors=" + doctors + "]";
	}

	
	
}
