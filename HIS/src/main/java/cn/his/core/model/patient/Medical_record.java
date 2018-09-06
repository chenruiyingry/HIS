package cn.his.core.model.patient;
import java.util.List;

import cn.his.core.model.Page;
import cn.his.core.model.drug.Drug_record;
public class Medical_record extends Page {

	private String code;//病历编号
	private String patient_code;//病人编号
	private String doctor_code;//医生编号
	private boolean isAssay;//是否化验
	private String assay_result;//化验结果
	private boolean isExamination;//是否检查
	private String examination_result;//检查结果
	private String diagnostic_result;//诊断结果
	private String treatment;//现状处理
	private boolean isHospitalization;//是否住院
	private String ward_number;//病房号
	private String bed_number;//病床号
	private int hospitalization_days;//住院天数
	private String date;//病历生成天数
	private String department;
	private List<Drug_record> drug_record;//药物信息实体类
	
	public Medical_record(String code, String patient_code, String doctor_code, boolean isAssay, String assay_result,
			boolean isExamination, String examination_result, String diagnostic_result, String treatment,
			boolean isHospitalization, String ward_number, String bed_number, int hospitalization_days, String date,
			List<Drug_record> drug_record) {
		super();
		this.code = code;
		this.patient_code = patient_code;
		this.doctor_code = doctor_code;
		this.isAssay = isAssay;
		this.assay_result = assay_result;
		this.isExamination = isExamination;
		this.examination_result = examination_result;
		this.diagnostic_result = diagnostic_result;
		this.treatment = treatment;
		this.isHospitalization = isHospitalization;
		this.ward_number = ward_number;
		this.bed_number = bed_number;
		this.hospitalization_days = hospitalization_days;
		this.date = date;
		this.drug_record = drug_record;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Medical_record() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPatient_code() {
		return patient_code;
	}
	public void setPatient_code(String patient_code) {
		this.patient_code = patient_code;
	}
	public String getDoctor_code() {
		return doctor_code;
	}
	public void setDoctor_code(String doctor_code) {
		this.doctor_code = doctor_code;
	}
	public boolean isAssay() {
		return isAssay;
	}
	public void setAssay(boolean isAssay) {
		this.isAssay = isAssay;
	}
	public String getAssay_result() {
		return assay_result;
	}
	public void setAssay_result(String assay_result) {
		this.assay_result = assay_result;
	}
	public boolean isExamination() {
		return isExamination;
	}
	public void setExamination(boolean isExamination) {
		this.isExamination = isExamination;
	}
	public String getExamination_result() {
		return examination_result;
	}
	public void setExamination_result(String examination_result) {
		this.examination_result = examination_result;
	}
	public String getDiagnostic_result() {
		return diagnostic_result;
	}
	public void setDiagnostic_result(String diagnostic_result) {
		this.diagnostic_result = diagnostic_result;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public boolean isHospitalization() {
		return isHospitalization;
	}
	public void setHospitalization(boolean isHospitalization) {
		this.isHospitalization = isHospitalization;
	}
	public String getWard_number() {
		return ward_number;
	}
	public void setWard_number(String ward_number) {
		this.ward_number = ward_number;
	}
	public String getBed_number() {
		return bed_number;
	}
	public void setBed_number(String bed_number) {
		this.bed_number = bed_number;
	}
	public int getHospitalization_days() {
		return hospitalization_days;
	}
	public void setHospitalization_days(int hospitalization_days) {
		this.hospitalization_days = hospitalization_days;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Drug_record> getDrug_record() {
		return drug_record;
	}
	public void setDrug_record(List<Drug_record> drug_record) {
		this.drug_record = drug_record;
	}

	@Override
	public String toString() {
		return "Medical_record [code=" + code + ", patient_code=" + patient_code + ", doctor_code=" + doctor_code
				+ ", isAssay=" + isAssay + ", Assay_result=" + assay_result + ", isExamination=" + isExamination
				+ ", examination_result=" + examination_result + ", diagnostic_result=" + diagnostic_result
				+ ", treatment=" + treatment + ", isHospitalization=" + isHospitalization + ", ward_number="
				+ ward_number + ", bed_number=" + bed_number + ", hospitalization_days=" + hospitalization_days
				+ ", date=" + date + ", drug_record=" + drug_record + "]";
	}
}
