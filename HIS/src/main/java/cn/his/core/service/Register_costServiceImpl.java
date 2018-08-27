package cn.his.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.his.core.dao.Register_costDao;
import cn.his.core.model.Level;
import cn.his.core.model.Register_cost;

@Service
@Transactional
public class Register_costServiceImpl implements Register_costService {
	
	@Resource
	private Register_costDao register_costDao;

	@Transactional(readOnly = true)
	@Override
	public Register_cost findRegister_costByLevel(Level level) {
		return register_costDao.findRegister_costByLevel(level);
	}

	@Override
	public boolean insertRegister_cost(Register_cost register_cost) {
		return register_costDao.insertRegister_cost(register_cost);
	}

	@Override
	public boolean updateRegister_cost(Register_cost register_cost) {
		return register_costDao.updateRegister_cost(register_cost);

	}

	@Override
	public boolean deleteRegister_cost(Register_cost register_cost) {
		return register_costDao.deleteRegister_cost(register_cost);

	}

	@Transactional(readOnly = true)
	@Override
	public List<Register_cost> findRegister_costList() {
		return register_costDao.findRegister_costList();
	}
	

}
