import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.his.core.model.Ward;
import cn.his.core.service.WardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestWardService {

	@Autowired
	private WardService wardService;
	
	@Test
	public void TestFindWardByBed_code() throws Exception {
		Ward ward = new Ward();
		ward.setBed_code("01");
		ward.setWard_code("001");
		System.out.println(ward.toString());
		ward = wardService.findWardByBed_codeAndWard_code(ward);
		System.out.println(ward.toString());
	}
	
	@Test
	public void TestFindWardByward_code() {
		Ward ward = wardService.findWardByward_code("001");
		System.out.println(ward.toString());
	}
	
	@Test
	public void TestSelectWardList() {
		List<Ward> wards = wardService.selectWardList();
		for (int i = 0; i < wards.size(); i++) {
			System.out.println(wards.get(i));
		}
	}
	
	@Test
	public void TestSelectBedListByWard_code() {
		List<Ward> wards = wardService.selectBedListByWard_code("001");
		for (int i = 0; i < wards.size(); i++) {
			System.out.println(wards.get(i));
		}
	}
	
	@Test
	public void TestFindLessBedByWard_code() {
		List<Ward> wards = wardService.findLessBedByWard_code("103");
		for (int i = 0; i < wards.size(); i++) {
			System.out.println(wards.get(i));
			System.out.println(wards.get(i).getType());
		}
	}
	
	@Test
	public void TestGetWardCount() {
		System.out.println(wardService.getWardCount());
	}
	
	@Test
	public void TestGetBedCountByWard_code() {
		System.out.println(wardService.getBedCountByWard_code("001"));
	}
	
	@Test
	public void TestGetLessBedCountByWord_code() {
		System.out.println(wardService.getLessBedCountByWord_code("001"));
	}
	
	@Test
	public void TestInsertWard() {
		Ward ward = new Ward();
		ward.setWard_code("103");
		System.out.println(ward.toString());
		wardService.insertWard(ward);
		System.out.println("添加成功");
	}
	
	@Test
	public void TestInsertBed() {
		Ward bed = new Ward();
		bed.setWard_code("103");
		bed.setBed_code("001");
		bed.setOccupy(false);
		bed.setPrice(200);
		bed.setType("NORMAL");
		System.out.println(bed.toString());
		wardService.insertWard(bed);
		System.out.println("添加成功");
	}
}
