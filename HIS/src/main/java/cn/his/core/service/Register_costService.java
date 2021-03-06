package cn.his.core.service;

import java.util.List;

import cn.his.core.model.Register_cost;

public interface Register_costService {
	
	/**
	 * 通过医师级别查找挂号费用信息
	 * @param 
	 * @return
	 */
	public Register_cost findRegister_costByLevel(String level);

	/**
	 * 添加医师级别
	 * @param 
	 */
	public boolean insertRegister_cost(Register_cost register_cost);
	
	/**
	 * 更新挂号费用信息
	 * @param 
	 */
	public boolean updateRegister_cost(Register_cost register_cost);
	
	/**
	 * 通过医师级别删除挂号费用信息
	 * @param 
	 */
	public boolean deleteRegister_cost(Register_cost register_cost);
	
	/**
	 * 获取所有挂号费用信息
	 * @param 
	 */
	public List<Register_cost> findRegister_costList();
}
