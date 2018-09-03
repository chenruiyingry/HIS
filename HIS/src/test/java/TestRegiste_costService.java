import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.his.core.model.Register_cost;
import cn.his.core.service.Register_costService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestRegiste_costService{

	@Autowired
	private Register_costService register_costService;
	
	@Test
	public void testInsertRegister_cost() {
		Register_cost register_cost = new Register_cost();
		register_cost.setLevel("ASSOCIATECHIEF");
		register_cost.setCost(30);
		if (register_costService.insertRegister_cost(register_cost)) {
			System.out.println("添加成功");
		}
	}
	
	@Test
	public void testFindRegister_costByLevel() {
		Register_cost register_cost = register_costService.findRegister_costByLevel("CHIEF");
		System.out.println(register_cost);
	}
	
	@Test
	public void testUpdateRegister_cost() {
		Register_cost register_cost = register_costService.findRegister_costByLevel("CHIEF");
		register_cost.setCost(100);
		if (register_costService.updateRegister_cost(register_cost)) {
			System.out.println("修改成功");
		}
	}
	
	@Test
	public void testDeleteRegister_cost() {
		Register_cost register_cost = new Register_cost();
		register_cost.setId(3);
		if (register_costService.deleteRegister_cost(register_cost)) {
			System.out.println("删除 成功");
		}
	}
	
	@Test
	public void testFindRegister_costList() {
		List<Register_cost> register_costs = register_costService.findRegister_costList();
		System.out.println(register_costs);
	}
}
