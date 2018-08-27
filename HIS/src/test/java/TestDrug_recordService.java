import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.his.common.page.Pagination;
import cn.his.core.model.drug.Drug_record;
import cn.his.core.service.drug.Drug_recordService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestDrug_recordService {

	@Autowired
	private Drug_recordService drug_recordService;
	
	@Test
	public void testFindDrug_recordList() {
		Drug_record drug_record = new Drug_record();
		drug_record.setCode("001");
		Pagination pagination = drug_recordService.findDrug_recordList(drug_record);
		System.out.println(pagination.getList());
	}
	
	@Test
	public void testFindDrug_recordByCode() {
		Drug_record drug_record = drug_recordService.findDrug_recordByCode("001");
		System.out.println(drug_record);
	}
}
