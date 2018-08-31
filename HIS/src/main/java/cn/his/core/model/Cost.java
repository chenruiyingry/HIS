package cn.his.core.model;

import java.io.Serializable;

public class Cost extends Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;//详细费用编号
	private String medical_code;//病历编号
	private double drug_cost;//药物费用
	private double hospitalization_cost;//住院费用
	private double assay_cost;//化验费用
	private double examination_cost;//检查费用
	private double register_cost;//挂号费用
	private double total;//总费用
	private payment payment;//支付方式
	private String flow_number;//流水号
	private String date;//生成日期
	
	public enum payment {
		CASH{
			public String getName() {return "现金";}
		},
		CARD{
			public String getName() {return "银行卡";}
		},
		WECHAT{
			public String getName() {return "微信支付";}
		},
		ALIPAY{
			public String getName() {return "支付宝";}
		},
		OTHERS{
			public String getName() {return "其他";}
		};
				
		public abstract String getName();
	}
	
	public Cost(String code, String medical_code, double drug_cost, double hospitalization_cost, double assay_cost,
			double examination_cost, double register_cost, double total, cn.his.core.model.Cost.payment payment,
			String flow_number, String date) {
		super();
		this.code = code;
		this.medical_code = medical_code;
		this.drug_cost = drug_cost;
		this.hospitalization_cost = hospitalization_cost;
		this.assay_cost = assay_cost;
		this.examination_cost = examination_cost;
		this.register_cost = register_cost;
		this.total = total;
		this.payment = payment;
		this.flow_number = flow_number;
		this.date = date;
	}

	public Cost() {
		super();
		// TODO Auto-generated constructor stub
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
	public double getDrug_cost() {
		return drug_cost;
	}
	public void setDrug_cost(double drug_cost) {
		this.drug_cost = drug_cost;
	}
	public double getHospitalization_cost() {
		return hospitalization_cost;
	}
	public void setHospitalization_cost(double hospitalization_cost) {
		this.hospitalization_cost = hospitalization_cost;
	}
	public double getAssay_cost() {
		return assay_cost;
	}
	public void setAssay_cost(double assay_cost) {
		this.assay_cost = assay_cost;
	}
	public double getExamination_cost() {
		return examination_cost;
	}
	public void setExamination_cost(double examination_cost) {
		this.examination_cost = examination_cost;
	}
	public double getRegister_cost() {
		return register_cost;
	}
	public void setRegister_cost(double register_cost) {
		this.register_cost = register_cost;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public payment getPayment() {
		return payment;
	}
	public void setPayment(payment payment) {
		this.payment = payment;
	}
	public String getFlow_number() {
		return flow_number;
	}

	public void setFlow_number(String flow_number) {
		this.flow_number = flow_number;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Cost [code=" + code + ", medical_code=" + medical_code + ", drug_cost=" + drug_cost
				+ ", hospitalization_cost=" + hospitalization_cost + ", assay_cost=" + assay_cost
				+ ", examination_cost=" + examination_cost + ", register_cost=" + register_cost + ", total=" + total
				+ ", payment=" + payment + ", date=" + date + "]";
	}
}
