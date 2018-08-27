package cn.his.core.dao.drug;

import java.util.List;

import cn.his.core.model.drug.Drug;

public interface DrugDao {

	/**
	 * 获取药品列表，分页，通过名字模糊查询，通过制造方模糊查询，通过主治功能模糊查询
	 * @return
	 */
	public List<Drug> findDrugList(Drug drug);
	
	/**
	 * 通过药品代码查询药品信息
	 * @param code
	 * @return
	 */
	public Drug findDrugByCode(String code);
	
	/**
	 * 获取药品数量，可以按照名字模糊查询、制造方模糊查询、主治功能模糊查询
	 * @param drug
	 * @return
	 */
	public int getDrugCount(Drug drug);
	
	/**
	 * 添加药品
	 */
	public boolean insertDrug(Drug drug);
	
	/**
	 * 修改药品信息
	 * @param drug
	 */
	public boolean updateDrug(Drug drug);
	
	/**
	 * 删除药品信息
	 * @param code
	 */
	public boolean deleteDrug(String code);
}
