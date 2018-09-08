package cn.his.core.model;
/*
 * 病房信息表
 */

import java.util.List;

public class Ward extends Page {

	private int id;
	private String ward_code;//病房编号
	private String bed_code;//病床编号 
	private String type;//类型 NORMAL"普通病房" ICU"重症监护室" CCU"心脏加护病房" VIP"高级病房"
	private double price;//价格
	private boolean occupy;//是否占用
	private List<Ward> beds;
	
	public Ward() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWard_code() {
		return ward_code;
	}

	public void setWard_code(String ward_code) {
		this.ward_code = ward_code;
	}

	public String getBed_code() {
		return bed_code;
	}

	public void setBed_code(String bed_code) {
		this.bed_code = bed_code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isOccupy() {
		return occupy;
	}

	public void setOccupy(boolean occupy) {
		this.occupy = occupy;
	}

	public List<Ward> getBeds() {
		return beds;
	}

	public void setBeds(List<Ward> beds) {
		this.beds = beds;
	}
	@Override
	public String toString() {
		return "Ward [id=" + id + ", ward_code=" + ward_code + ", bed_code=" + bed_code + ", type=" + type + ", price="
				+ price + ", occupy=" + occupy + ", beds=" + beds + "]";
	}
	

	
}
