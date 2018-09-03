package cn.his.core.model;
/*
 * 挂号费用表
 */
public class Register_cost {
	
	private int id;//id
	private String level;//医师级别
	private double cost;//挂号费用
	
	public Register_cost(String level, double cost) {
		super();
		this.level = level;
		this.cost = cost;
	}
	public Register_cost() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Register_cost [id=" + id + ", level=" + level + ", cost=" + cost + "]";
	}
	
}
