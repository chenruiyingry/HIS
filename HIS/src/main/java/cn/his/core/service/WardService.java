package cn.his.core.service;

import java.util.List;

import cn.his.core.model.Ward;

public interface WardService {
	
	/**
	 * 通过病床号，查询病房所有信息
	 * @param bed_code
	 * @return
	 */
	public Ward findWardByBed_codeAndWard_code(Ward ward);
	
	/**
	 * 通过病房编号，查询所有信息
	 * @param ward_code
	 * @return
	 */
	public Ward findWardByward_code(String ward_code);
	
	/**
	 * 查询病房
	 * @return
	 */
	public List<Ward> selectWardList();
	
	/**
	 * 通过病房号查询病床集合
	 * @param ward_code
	 * @return
	 */
	public List<Ward> selectBedListByWard_code(String ward_code);
	
	/**
	 * 查询某个病房的空床位
	 * @param word_code
	 * @return
	 */
	public List<Ward> findLessBedByWard_code(String ward_code);
	
	/**
	 * 通过id查询信息
	 * @param id
	 * @return
	 */
	public Ward selectWardByID(int id);
	
	/**
	 * 查询医院病房数量
	 * @return
	 */
	public int getWardCount();
	
	/**
	 * 查询某病房病床数量
	 * @param word_code
	 * @return
	 */
	public int getBedCountByWard_code(String ward_code);
	
	/**
	 * 查询某病房的未被占用病床数量
	 * @param word_code
	 * @return
	 */
	public int getLessBedCountByWord_code(String ward_code);
	
	/**
	 * 添加新的病房或病床
	 * @param ward
	 */
	public boolean insertWard(Ward ward);
	
	/**
	 * 通过id修改病房信息
	 * @param ward
	 */
	public boolean updateWardById(Ward ward);
	
	/**
	 * 通过病房号修改病房信息
	 * @param ward
	 * @return
	 */
	public boolean updateWardByWard_code(Ward ward, String oldWard_code);
	
	/**
	 * 通过病房号进行删除
	 * @param ward_code
	 * @return
	 */
	public boolean deleteWard(int id);
}

