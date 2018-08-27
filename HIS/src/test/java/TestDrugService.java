import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.his.common.page.Pagination;
import cn.his.core.model.drug.Drug;
import cn.his.core.service.drug.DrugService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestDrugService {

	@Autowired
	private DrugService drugService;
	
	@Test
	public void testInsertDrug() {
		Drug drug = new Drug();
		drug.setCode("0004");
		drug.setName("头孢拉定胶囊");
		drug.setFunction("敏感菌所致的急性咽炎、扁桃体炎、中耳炎、支气管炎和肺炎等呼吸道感染、泌尿生殖道感染及皮肤软组织感染等");
		drug.setProduce_date("2018-07-26");
		drug.setEffective_date("2020-07-26");
		drug.setManufacturer("中国制药");
		drug.setUnit("颗");
		drug.setPurchase_price(8.00);
		drug.setSale_price(12.00);
		drug.setStore(500);
		System.out.println(drug.toString());
		drugService.insertDrug(drug);
		System.out.println("添加成功");
	}
	
	@Test
	public void testFindDrugList() {
		Drug drug = new Drug();
		Pagination pagination = drugService.findDrugList(drug);
		System.out.println(pagination.getList());
	}
	
	@Test
	public void testFindDrugByCode() {
		System.out.println(drugService.findDrugByCode("0001"));
	}
}
