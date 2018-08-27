package cn.his.core.model.doctor;

/*
 * 科室表
 */
public class Department {

	private String code;//科室编号
	private String name;//科室名字
	private String introduction;//简介
	private int people;//人数
	private Doctor doctor;
	
	public Department(String code, String name, String introduction, int people) {
		super();
		this.code = code;
		this.name = name;
		this.introduction = introduction;
		this.people = people;
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

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Department [code=" + code + ", name=" + name
				+ ", introduction=" + introduction + ", people=" + people + "]";
	}
	
	
}
