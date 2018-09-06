package cn.his.core.model.patient;

import java.util.List;

import cn.his.core.model.Page;

/*
 * 病人信息表
 */
public class Patient extends Page {
	private int id;//id
	private String code;//编号
	private String doctor_code;//医生编号
	private String name;//姓名
	private String sex;//性别
	private int age;//年龄
	private String phone;//联系电话
	private String insurance_type;//医保类型
	private String present_illness;//现病史
	private String past_illness;//既病史
	private String allergy;//过敏史
	private int status;//病人状态
	private List<Medical_record> medical_record;
	
	public Patient(String code, String doctor_code, String name, String sex, int age, String phone, String insurance_type,
			String present_illness, String past_illness, String allergy, int status, List<Medical_record> medical_record) {
		super();
		this.code = code;
		this.doctor_code = doctor_code;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.phone = phone;
		this.insurance_type = insurance_type;
		this.present_illness = present_illness;
		this.past_illness = past_illness;
		this.allergy = allergy;
		this.status = status;
		this.medical_record = medical_record;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getDoctor_code() {
		return doctor_code;
	}
	public void setDoctor_code(String doctor_code) {
		this.doctor_code = doctor_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getInsurance_type() {
		return insurance_type;
	}
	public void setInsurance_type(String insurance_type) {
		this.insurance_type = insurance_type;
	}
	public String getPresent_illness() {
		return present_illness;
	}
	public void setPresent_illness(String present_illness) {
		this.present_illness = present_illness;
	}
	public String getPast_illness() {
		return past_illness;
	}
	public void setPast_illness(String past_illness) {
		this.past_illness = past_illness;
	}
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<Medical_record> getMedical_record() {
		return medical_record;
	}
	public void setMedical_record(List<Medical_record> medical_record) {
		this.medical_record = medical_record;
	}
	@Override
	public String toString() {
		return "Patient [code=" + code + ", name=" + name + ", sex=" + sex + ", age=" + age + ", phone=" + phone
				+ ", insurance_type=" + insurance_type + ", present_illness=" + present_illness + ", past_illness="
				+ past_illness + ", allergy=" + allergy + ", status=" + status + ", medical_record=" + medical_record
				+ "]";
	}
	
}
