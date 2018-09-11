import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.his.common.page.Pagination;
import cn.his.core.model.patient.Medical_record;
import cn.his.core.service.patient.Medical_recordService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestMedical_recordService {

	@Autowired
	private Medical_recordService medical_recordService;
	
	@Test
	public void testFindMedical_recordList() {
		Medical_record medical_record = new Medical_record();
		medical_record.setCode("1001000");
		Pagination pagination = medical_recordService.findMedical_recordList(medical_record);
		System.out.println(pagination.getList());
	}
	
	@Test
	public void TestInsertMedical_record() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = dateFormat.format(new Date());
		Medical_record medical_record = new Medical_record();
		medical_record.setCode("1001002");
		medical_record.setPatient_code("10011");
		medical_record.setDoctor_code("326525");
		medical_record.setAssay(true);
		medical_record.setAssay_result("一切正常");
		medical_record.setExamination(true);
		medical_record.setExamination_result("一切正常");
		medical_record.setDiagnostic_result("暂时未发现问题");
		medical_record.setTreatment("观察数日");
		medical_record.setHospitalization(true);
		medical_record.setWard_number("103");
		medical_record.setBed_number("001");
		medical_record.setHospitalization_days(5);
		medical_record.setDate(dateStr);
		System.out.println(medical_record.toString());
		medical_recordService.insertMedical_record(medical_record);
		System.out.println("添加成功");
	}
	
	@Test
	public void TestFindMedical_recordBycode() {
		Medical_record medical_record = medical_recordService.findMedical_recordByCode("1001000");
		System.out.println(medical_record);
	}
	
}
