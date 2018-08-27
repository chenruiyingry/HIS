import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.his.core.model.Cost;
import cn.his.core.model.Cost.payment;
import cn.his.core.service.CostService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestCostService{
	
	@Autowired
	private CostService costService;
	
	@Test
	public void testInsertCost() {
		Cost cost = new Cost();
		cost.setAssay_cost(50);
		cost.setCode("100202");
		cost.setDate("2018-07-05");
		cost.setDrug_cost(1000);
		cost.setExamination_cost(102);
		cost.setFlow_number("12315646513");
		cost.setHospitalization_cost(2000);
		cost.setMedical_code("1001000");
		cost.setPayment(payment.ALIPAY);
		cost.setRegister_cost(20);
		cost.setTotal(25000);
		System.out.println(cost);
		if (costService.insertCost(cost)) {
			System.out.println("添加成功");
		}
	}
	
	@Test
	public void testFindCostByMedical_code() {
		List<Cost> costs = (List<Cost>) costService.findCostByMedical_code("1001000");
		System.out.println(costs);
	}
	
	@Test
	public void testFindCostByCode() {
		Cost cost = costService.findCostByCode("100202");
		System.out.println(cost);
	}
}
