package cn.his.core.model.doctor;

import java.util.List;

import cn.his.core.model.Page;
import cn.his.core.model.Sex;
import cn.his.core.model.patient.Medical_record;
import cn.his.core.model.patient.Patient;

/*
 * 医生表
 */
public class Doctor extends Page {
	private String code;//医生编号
	private String password;//密码
	private String name;//姓名
	private Sex sex;//性别
	private String native_place;//籍贯
	private String nation;//民族
	private String birth;//生日
	private String degree;//最高学位
	private String graduate;//毕业院校
	private String address;//联系地址
	private String phone;//联系电话
	private String email;//弟子邮件
	private String qualification;//资格证书编码
	private String license;//执业证书编码
	private String department_code;//科室
	private int level;//医师级别
	private String title;//职称
	private String duty;//职务
	private String hiredate;//入职时间
	private String major;//从事专业
	private String remark;//备注
	private boolean isWork;//是否值班
	private String work_time;//工作时间
	private boolean isFirst;//是否第一次登陆
	private String image_url;//照片连接
	private String introduction;//简介
	private List<Patient> patient;//病人实体
	private List<Medical_record> medical_record;//病历表实体
	
	public Doctor(String code, String password, String name, Sex sex, String native_place, String nation, String birth,
			String degree, String graduate, String address, String phone, String email, String qualification,
			String license, String department, int level, String title, String duty, String hiredate, String major,
			String remark, boolean isWork, String work_time, boolean isFirst, String image_url, String introduction,
			List<Patient> patient, List<Medical_record> medical_record) {
		super();
		this.code = code;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.native_place = native_place;
		this.nation = nation;
		this.birth = birth;
		this.degree = degree;
		this.graduate = graduate;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.qualification = qualification;
		this.license = license;
		this.department_code = department;
		this.level = level;
		this.title = title;
		this.duty = duty;
		this.hiredate = hiredate;
		this.major = major;
		this.remark = remark;
		this.isWork = isWork;
		this.work_time = work_time;
		this.isFirst = isFirst;
		this.image_url = image_url;
		this.introduction = introduction;
		this.patient = patient;
		this.medical_record = medical_record;
	}
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Medical_record> getMedical_record() {
		return medical_record;
	}
	public void setMedical_record(List<Medical_record> medical_record) {
		this.medical_record = medical_record;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public String getNative_place() {
		return native_place;
	}
	public void setNative_place(String native_place) {
		this.native_place = native_place;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getGraduate() {
		return graduate;
	}
	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getDepartment() {
		return department_code;
	}
	public void setDepartment(String department_code) {
		this.department_code = department_code;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public boolean isWork() {
		return isWork;
	}
	public void setWork(boolean isWork) {
		this.isWork = isWork;
	}
	public String getWork_time() {
		return work_time;
	}
	public void setWork_time(String work_time) {
		this.work_time = work_time;
	}
	public boolean isFirst() {
		return isFirst;
	}
	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public List<Patient> getPatient() {
		return patient;
	}
	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Doctor [code=" + code + ", password=" + password + ", name=" + name + ", sex=" + sex + ", native_place="
				+ native_place + ", nation=" + nation + ", birth=" + birth + ", degree=" + degree + ", graduate="
				+ graduate + ", address=" + address + ", phone=" + phone + ", email=" + email + ", qualification="
				+ qualification + ", license=" + license + ", department=" + department_code + ", level=" + level
				+ ", title=" + title + ", duty=" + duty + ", hiredate=" + hiredate + ", major=" + major + ", remark="
				+ remark + ", isWork=" + isWork + ", work_time=" + work_time + ", isFirst=" + isFirst + ", image_url="
				+ image_url + ", introduction=" + introduction + ", patient=" + patient + ", medical_record="
				+ medical_record + "]";
	}

}