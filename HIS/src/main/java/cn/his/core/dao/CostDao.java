package cn.his.core.dao;

import java.util.List;

import cn.his.core.model.Cost;

public interface CostDao {
	
	/**
	 * 根据病历编号查询所有内容
	 * @param medical_code
	 * @return
	 */
	public List<Cost> findCostByMedical_code(String medical_code);
	
	/**
	 *  根据详细费用编号查询所有内容
	 * @param code
	 * @return
	 */
	public Cost findCostByCode(String code);
	
	/**
	 * 通过病历号查询该病历号所有缴费记录
	 * @param cost
	 * @return
	 */
	public int getCostCount(Cost cost);
	
	/**
	 * 查询某病历号的所有缴费单 
	 * @param cost
	 * @return
	 */
	public List<Cost> findCostList(Cost cost);
	
	/**
	 * 添加费用信息
	 * @param cost
	 * @return
	 */
	public boolean insertCost(Cost cost);
	
	/**
	 * 通过详细费用编号修改费用表
	 * @param cost
	 * @return
	 */
	public boolean updateCost(Cost cost);
	
	/**
	 * 通过详细费用单号删除费用表
	 * @param code
	 * @return
	 */
	public boolean deleteAll(String code);
}
