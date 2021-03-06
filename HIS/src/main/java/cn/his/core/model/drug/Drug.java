package cn.his.core.model.drug;

import cn.his.core.model.Page;

public class Drug extends Page {
	private int id;//id
	private String code;//药物编号
	private String name;//药物名字
	private String funcction;//药物主治功能
	private String produce_date;//生产日期
	private String effective_date;//有效日期
	private String manufacturer;//制造商
	private String unit;//计量单位
	private double purchase_price;//进货价
	private double sale_price;//售价
	private int store ;//库存量
	private String spec;//规格
	public Drug(String code, String name, String function, String produce_date,
			String effective_date, String manufacturer, String unit,
			double purchase_price, double sale_price, int store, String spec) {
		super();
		this.code = code;
		this.name = name;
		this.funcction = function;
		this.produce_date = produce_date;
		this.effective_date = effective_date;
		this.manufacturer = manufacturer;
		this.unit = unit;
		this.purchase_price = purchase_price;
		this.sale_price = sale_price;
		this.store = store;
		this.spec = spec;
	}
	public Drug() {
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
	public String getName() {
		return name;
	}
	public String getFuncction() {
		return funcction;
	}
	public void setFuncction(String funcction) {
		this.funcction = funcction;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFunction(String function) {
		this.funcction = function;
	}
	public String getProduce_date() {
		return produce_date;
	}
	public void setProduce_date(String produce_date) {
		this.produce_date = produce_date;
	}
	public String getEffective_date() {
		return effective_date;
	}
	public void setEffective_date(String effective_date) {
		this.effective_date = effective_date;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getPurchase_price() {
		return purchase_price;
	}
	public void setPurchase_price(double purchase_price) {
		this.purchase_price = purchase_price;
	}
	public double getSale_price() {
		return sale_price;
	}
	public void setSale_price(double sale_price) {
		this.sale_price = sale_price;
	}
	public int getStore() {
		return store;
	}
	public void setStore(int store) {
		this.store = store;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	@Override
	public String toString() {
		return "Drug [code=" + code + ", name=" + name + ", function=" + funcction + ", produce_date=" + produce_date
				+ ", effective_date=" + effective_date + ", manufacturer=" + manufacturer + ", unit=" + unit
				+ ", purchase_price=" + purchase_price + ", sale_price=" + sale_price + ", store=" + store + ", spec="
				+ spec + "]";
	}
	
}
