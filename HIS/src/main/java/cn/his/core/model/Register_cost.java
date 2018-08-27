package cn.his.core.model;
/*
 * 挂号费用表
 */
public class Register_cost {
	
	private int level;//医师级别
	private String cost;//挂号费用
	public Register_cost(int level, String cost) {
		super();
		this.level = level;
		this.cost = cost;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Register_cost [level=" + level + ", cost=" + cost + "]";
	}
	
}
