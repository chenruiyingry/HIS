package cn.his.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.his.core.dao.WardDao;
import cn.his.core.model.Ward;

@Service
@Transactional
public class WardServiceImpl implements WardService{

	@Resource
	private WardDao wardDao;
	
	@Transactional(readOnly = true)
	@Override
	public Ward findWardByBed_codeAndWard_code(Ward ward) {
		return wardDao.findWardByBed_codeAndWard_code(ward);
	}

	@Transactional(readOnly = true)
	@Override
	public Ward findWardByward_code(String ward_code) {
		return wardDao.findWardByWard_code(ward_code);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Ward> selectWardList() {
		return wardDao.selectWardList();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Ward> findLessBedByWard_code(String ward_code) {
		return wardDao.findLessBedByWard_code(ward_code);
	}

	@Transactional(readOnly = true)
	@Override
	public int getWardCount() {
		return wardDao.getWardCount();
	}

	@Transactional(readOnly = true)
	@Override
	public int getBedCountByWard_code(String ward_code) {
		return wardDao.getBedCountByWard_code(ward_code);
	}

	@Transactional(readOnly = true)
	@Override
	public int getLessBedCountByWord_code(String ward_code) {
		return wardDao.getLessBedCountByWord_code(ward_code);
	}

	@Override
	public boolean insertWard(Ward ward) {
		return wardDao.insertWard(ward);
	}

	@Override
	public boolean updateWardById(Ward ward) {
		return wardDao.updateWardById(ward);
	}

	@Override
	public boolean deleteWard(int id) {
		return wardDao.deleteWard(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Ward> selectBedListByWard_code(String ward_code) {
		return wardDao.selectBedListByWard_code(ward_code);
	}

}
