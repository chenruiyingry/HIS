package cn.his.core.model;
/*
 * 病房信息表
 */
public class Ward extends Page {

	private String ward_code;//病房编号
	private String bed_code;//病床编号
	private Type type;//类型
	private double price;//价格
	private boolean isOccupy;//是否占用
	
	public enum Type {
		NORMAL{
			public String getName() {return "普通病房";}
		},
		ICU{
			public String getName() {return "重症监护室";}
		},
		CCU{
			public String getName() {return "心脏加护病房";}
		},
		VIP{
			public String getName() {return "高级病房";}
		};
		
		public abstract String getName();
	}
	
	public Ward() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ward(String ward_code, String bed_code, Type type, double price, boolean isOccupy) {
		super();
		this.ward_code = ward_code;
		this.bed_code = bed_code;
		this.type = type;
		this.price = price;
		this.isOccupy = isOccupy;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	public boolean isOccupy() {
		return isOccupy;
	}
	public void setOccupy(boolean isOccypy) {
		this.isOccupy = isOccypy;
	}
	@Override
	public String toString() {
		return "Ward [ward_code=" + ward_code + ", bed_code=" + bed_code + ", type=" + type + ", price=" + price
				+ ", isOccupy=" + isOccupy + "]";
	}
	
}
