package cn.his.core.model.drug;

import cn.his.core.model.Page;

/*
 * 药物记录表
 */
public class Drug_record extends Page {

	private String code;//药物记录编号
	private String medical_code;//病历编号
	private String drug_code;//药品编号
	private int number;//数量
	private int status;//缴费/取回情况
	private Drug drug;//药物信息实体类
	private double totalmoney;

	public double getTotalmoney() {
		return totalmoney = drug.getSale_price() * number;
	}

	public Drug_record(String code, String medical_code, String drug_code, int number, int status, Drug drug) {
		super();
		this.code = code;
		this.medical_code = medical_code;
		this.drug_code = drug_code;
		this.number = number;
		this.status = status;
		this.drug = drug;
	}

	public Drug_record() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMedical_code() {
		return medical_code;
	}

	public void setMedical_code(String medical_code) {
		this.medical_code = medical_code;
	}

	public String getDrug_code() {
		return drug_code;
	}

	public void setDrug_code(String drug_code) {
		this.drug_code = drug_code;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Drug_record [code=" + code + ", medical_code=" + medical_code + ", drug_code=" + drug_code + ", number="
				+ number + ", status=" + status + ", drug=" + drug + "]";
	}
	
}
